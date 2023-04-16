package com.example.khelon.mainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.khelon.newsFragment.NewsViewAddapterClass;
import com.example.khelon.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;


public class NewsFragment extends Fragment {

    ImageButton bottomLayout;
    TabLayout tabLayout;
    ViewPager2 viewPager;

    NewsViewAddapterClass newsViewAddapterClass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        bottomLayout = v.findViewById(R.id.optionsNews);
        bottomLayout.setOnClickListener(view ->
                showDialog());

        tabLayout = v.findViewById(R.id.newsTabLayout);
        viewPager = v.findViewById(R.id.newsViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("BU"));
        tabLayout.addTab(tabLayout.newTab().setText("Global"));

        newsViewAddapterClass = new NewsViewAddapterClass(getActivity());

        viewPager.setAdapter(newsViewAddapterClass);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });



        return v;
    }

    private void showDialog(){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getActivity(),R.style.BottomSheetDialogTheme);

        bottomSheetDialog.setContentView(R.layout.bottomsheet);

        LinearLayout aboutUs = bottomSheetDialog.findViewById(R.id.aboutUsLayout);
        
        aboutUs.setOnClickListener(view ->
                Toast.makeText(getActivity(), "About Us!", Toast.LENGTH_SHORT).show());


        bottomSheetDialog.show();
    }


}