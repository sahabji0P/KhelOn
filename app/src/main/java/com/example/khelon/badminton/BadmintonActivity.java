package com.example.khelon.badminton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.khelon.R;
import com.google.android.material.tabs.TabLayout;

public class BadmintonActivity extends AppCompatActivity {

    ImageView badmintonBackbtn;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    BadmintonAdaptorClass viewAdapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);

        badmintonBackbtn = findViewById(R.id.badmintonBackbtn);

        badmintonBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BadmintonActivity.super.onBackPressed();
                finish();
            }
        });

        tabLayout = findViewById(R.id.badmintonTabLayout);
        viewPager2 = findViewById(R.id.badmintonViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Live"));
        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Support"));

        viewAdapterClass = new BadmintonAdaptorClass(this);

        viewPager2.setAdapter(viewAdapterClass);

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
    }
}