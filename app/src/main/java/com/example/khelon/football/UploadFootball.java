package com.example.khelon.football;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;
import com.example.khelon.cricket.Upload_Cricket_Support;

public class UploadFootball extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.upload_football);

        backBtn = findViewById(R.id.FootballUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadFootball.super.onBackPressed();
                finish();
            }
        });
    }
}