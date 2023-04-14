package com.example.khelon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khelon.newsFragment.WorldFragment;
import com.example.khelon.newsFragment.bNewzFragment;

public class NewsViewAddapterClass extends FragmentStateAdapter {
    public NewsViewAddapterClass(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new bNewzFragment();

            case 1:
                return new WorldFragment();


            default:
                return new bNewzFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
