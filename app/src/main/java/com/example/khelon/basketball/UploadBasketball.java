package com.example.khelon.basketball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;
import com.example.khelon.cricket.Upload_Cricket_Support;

public class UploadBasketball extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_basketball);

        backBtn = findViewById(R.id.basketballUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadBasketball.super.onBackPressed();
                finish();
            }
        });
    }
}