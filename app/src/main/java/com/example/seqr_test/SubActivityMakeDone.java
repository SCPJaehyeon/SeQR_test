package com.example.seqr_test;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivityMakeDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Acrivity의 기본 꼴
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makedone);  // setContentView 메소드로 레이아웃파일과 연결

        ImageView imageView = this.findViewById(R.id.view_qr);
        Bitmap bitmap = getIntent().getParcelableExtra("pic");
        imageView.setImageBitmap(bitmap);
    }

    public void btn2Click(View view) {
        Toast.makeText(SubActivityMakeDone.this,"뒤로가기",Toast.LENGTH_SHORT).show();
        finish();
    }

}
