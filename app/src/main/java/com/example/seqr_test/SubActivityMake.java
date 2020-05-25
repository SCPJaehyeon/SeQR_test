package com.example.seqr_test;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SubActivityMake extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Acrivity의 기본 꼴
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);  // setContentView 메소드로 레이아웃파일과 연결
    }

    public void btn2Click(View view) {
        Toast.makeText(SubActivityMake.this,"뒤로가기",Toast.LENGTH_SHORT).show();
        finish();
    }
}
