package com.example.seqr_test;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class SubActivityMake extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Acrivity의 기본 꼴
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);  // setContentView 메소드로 레이아웃파일과 연결
    }

    public void btn2Click(View view) {
        Toast.makeText(SubActivityMake.this,"뒤로가기",Toast.LENGTH_SHORT).show();
        finish();
    }

    public void MakeQr(View view)
    {
        EditText editText = findViewById(R.id.input_url);
        String text2Qr = editText.getText().toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            Intent intent = new Intent(context, SubActivityMakeDone.class);
            intent.putExtra("pic",bitmap);
            context.startActivity(intent);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
