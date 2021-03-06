package com.example.seqr_test;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/*
 * QR코드 찍기 + URL 접속
 */
public class SubActivityTake extends AppCompatActivity {

    /*
    Acrivity의 기본 꼴
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentIntegrator QR_Scan = new IntentIntegrator(this);  // Zxing을 불러오는 부분
        QR_Scan.setOrientationLocked(false); // 휴대폰 방향에 따라 가로, 세로로 자동 변경
        QR_Scan.setPrompt("Sample Text!");
        QR_Scan.initiateScan();  // 실행

        // setContentView 메소드로 레이아웃파일과 연결
        setContentView(R.layout.activity_take);
    }

    private IntentResult result;

    /*
    QR코드 take 모드를 시작하고 결과를 반환하기 위한 메서드
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);  // QR코드를 스캔한 결과값
        if(result != null) {
            if(result.getContents() == null) {  // QR코드 URL 값
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    /*
    메인 화면으로 돌아가기
     */
    public void btn2Click(View view) {

        Toast.makeText(SubActivityTake.this,"뒤로가기",Toast.LENGTH_SHORT).show();
        finish();

    }

    /*
    QR코드 링크 접속 Connection버튼
     */
    public void btn3Click(View view) {

        String url = "http://";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url+result.getContents()));
        startActivity(intent);

    }

}
