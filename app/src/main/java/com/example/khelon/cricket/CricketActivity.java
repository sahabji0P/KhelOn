package com.example.khelon.cricket;

import static com.example.khelon.CheckAdmin.checkAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CricketActivity extends AppCompatActivity {

    FirebaseUser firebaseuser;
    ImageView postButton;
    ImageView cBackBtn;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    CricketAdapterView cricketAdapterView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        cBackBtn = findViewById(R.id.cricketBackbtn);

        cBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CricketActivity.super.onBackPressed();
                finish();
            }
        });
        tabLayout = findViewById(R.id.cricketTabLayout);
        viewPager2 = findViewById(R.id.cricketViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Live"));
        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Support"));

        cricketAdapterView = new CricketAdapterView(this);

        viewPager2.setAdapter(cricketAdapterView);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        firebaseuser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseuser.getUid();

        postButton = findViewById(R.id.CricketPostButton);

        if (checkAdmin(uid)){
            postButton.setVisibility(View.VISIBLE);
            postButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CricketActivity.this, UploadCricket.class));
//                    finish();
                }
            });
        }else {
            postButton.setVisibility(View.GONE);
        }

    }
}