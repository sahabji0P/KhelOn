package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FootballActivity extends AppCompatActivity {

    ImageView fBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_);

        fBackBtn = findViewById(R.id.footballBackbtn);

        fBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FootballActivity.super.onBackPressed();
                finish();
            }
        });
    }
}