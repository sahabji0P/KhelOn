package com.example.khelon.badminton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;

public class UploadBadminton extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_badminton);

        backBtn = findViewById(R.id.badmintonUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadBadminton.super.onBackPressed();
                finish();
            }
        });
    }
}