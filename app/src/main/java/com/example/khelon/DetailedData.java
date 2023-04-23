package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.khelon.R;

public class DetailedData extends AppCompatActivity {

    TextView detailHeading, detailDesc;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_data);

        detailDesc = findViewById(R.id.contentDescView);
        detailHeading = findViewById(R.id.contentHeadingView);
        detailImage = findViewById(R.id.contentImageView);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText((bundle.getString("Description")));
            detailHeading.setText((bundle.getString("Heading")));
            Glide.with(this).load(bundle.get("Image")).into(detailImage);
        }
    }
}