package com.example.seqr_test;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /*
    건드려야 될것
    재현 : app/java/com.example.seqr_test/SubActivityMake, app/res/layout/activity_make
    현진 : app/java/com.example.seqr_test/SubActivityTake, app/res/layout/activity_take
    송이 : app/java/com.example.seqr_test/SubActivityReport, app/res/layout/activity_report
     */ 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClickMake(View view) {  // 버튼에 직접 onClick 속성을 부여하는 방법
        Toast.makeText(MainActivity.this,"Make 버튼을 Click 하셨습니다.",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SubActivityMake.class);
        startActivity(intent);
    }

    public void btnClickTake(View view) {  // 버튼에 직접 onClick 속성을 부여하는 방법
        Toast.makeText(MainActivity.this,"Take 버튼을 Click 하셨습니다.",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SubActivityTake.class);
        startActivity(intent);
    }

    public void btnClickReport(View view) {
        Toast.makeText(MainActivity.this,"Report 버튼을 Click 하셨습니다.",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SubActivityReport.class);
        startActivity(intent);
    }
}
