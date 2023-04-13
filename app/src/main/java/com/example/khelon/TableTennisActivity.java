package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TableTennisActivity extends AppCompatActivity {

    ImageView TTbackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_tennis);

        TTbackBtn = findViewById(R.id.tabletennisBackbtn);

        TTbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableTennisActivity.super.onBackPressed();
                finish();
            }
        });
    }
}