package com.example.khelon.cricket;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khelon.badminton.badmintonLive;
import com.example.khelon.badminton.badmintonRecent;
import com.example.khelon.badminton.badmintonSupport;

public class CricketAdapterView extends FragmentStateAdapter {
    public CricketAdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new cricketRecent();
            case 2:
                return new cricketSupport();

            default:
                return new cricketLive();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
