package com.example.khelon.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.khelon.R;

public class RegistrationDetailed extends AppCompatActivity {

    TextView detailHeading, detailDesc;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_registration);

        detailHeading = findViewById(R.id.registrationPostTitle);
        detailDesc = findViewById(R.id.registrationPostDescription);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText((bundle.getString("Description")));
            detailHeading.setText((bundle.getString("Heading")));
        }

    }
}