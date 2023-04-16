package com.example.khelon.tabletennis;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khelon.badminton.badmintonLive;
import com.example.khelon.badminton.badmintonRecent;
import com.example.khelon.badminton.badmintonSupport;

public class TableTennisAdapterView extends FragmentStateAdapter {
    public TableTennisAdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new tabletennisRecent();
            case 2:
                return new tabletennisSupport();

            default:
                return new tabletennisLive();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
