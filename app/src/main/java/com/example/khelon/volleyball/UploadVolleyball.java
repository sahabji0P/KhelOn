package com.example.khelon.volleyball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;


public class UploadVolleyball extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_volleyball);

        backBtn = findViewById(R.id.volleyUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadVolleyball.super.onBackPressed();
                finish();
            }
        });
    }
}