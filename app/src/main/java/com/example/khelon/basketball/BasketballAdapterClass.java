package com.example.khelon.basketball;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BasketballAdapterClass extends FragmentStateAdapter {
    public BasketballAdapterClass(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new basketballRecent();
            case 2:
                return new basketballSupport();

            default:
                return new basketballLive();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
