package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BasketballActivity extends AppCompatActivity {

    ImageView bBallBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        bBallBackBtn = findViewById(R.id.basketballBackbtn);

        bBallBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasketballActivity.super.onBackPressed();
                finish();
            }
        });
    }
}