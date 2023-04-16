package com.example.khelon.football;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khelon.badminton.badmintonLive;
import com.example.khelon.badminton.badmintonRecent;
import com.example.khelon.badminton.badmintonSupport;

public class FootballAdapterView extends FragmentStateAdapter {
    public FootballAdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new footballRecent();
            case 2:
                return new footballSupport();

            default:
                return new footballLive();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
