package com.example.seqr_test;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class SubActivityTake extends AppCompatActivity {

    private IntentIntegrator QR_Scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Acrivity의 기본 꼴
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take);  // setContentView 메소드로 레이아웃파일과 연결

        QR_Scan = new IntentIntegrator(this);
        QR_Scan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        QR_Scan.setPrompt("Sample Text!");
        QR_Scan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void btn2Click(View view) {
        Toast.makeText(SubActivityTake.this,"뒤로가기",Toast.LENGTH_SHORT).show();
        finish();
    }
}
