package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CricketActivity extends AppCompatActivity {

    ImageView cBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        cBackBtn = findViewById(R.id.cricketBackbtn);

        cBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CricketActivity.super.onBackPressed();
                finish();
            }
        });
    }
}