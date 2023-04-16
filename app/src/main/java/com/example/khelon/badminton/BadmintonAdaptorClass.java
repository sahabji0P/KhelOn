package com.example.khelon.badminton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BadmintonAdaptorClass extends FragmentStateAdapter {
    public BadmintonAdaptorClass(@NonNull FragmentActivity fragmentActivity) {
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
