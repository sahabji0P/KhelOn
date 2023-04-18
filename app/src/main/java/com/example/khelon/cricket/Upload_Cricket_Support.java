package com.example.khelon.cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;

public class Upload_Cricket_Support extends AppCompatActivity {

    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_cricket_support);

        backBtn = findViewById(R.id.uploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload_Cricket_Support.super.onBackPressed();
                finish();
            }
        });
    }
}