package com.example.khelon.volleyball;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khelon.badminton.badmintonLive;
import com.example.khelon.badminton.badmintonRecent;
import com.example.khelon.badminton.badmintonSupport;

public class VolleyBallAdapterView extends FragmentStateAdapter {
    public VolleyBallAdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new badmintonRecent();
            case 2:
                return new badmintonSupport();

            default:
                return new badmintonLive();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
