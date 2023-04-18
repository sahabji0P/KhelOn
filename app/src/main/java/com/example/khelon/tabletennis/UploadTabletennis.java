package com.example.khelon.tabletennis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;
import com.example.khelon.cricket.Upload_Cricket_Support;

public class UploadTabletennis extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_tabletennis);

        backBtn = findViewById(R.id.TableTennisUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadTabletennis.super.onBackPressed();
                finish();
            }
        });
    }
}