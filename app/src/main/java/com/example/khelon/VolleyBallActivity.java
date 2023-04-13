package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VolleyBallActivity extends AppCompatActivity {

    ImageView VballBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_ball);

        VballBackBtn = findViewById(R.id.volleyballBackbtn);

        VballBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolleyBallActivity.super.onBackPressed();
                finish();
            }
        });
    }
}