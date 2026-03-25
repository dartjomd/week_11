package com.example.week_11.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

// adapter for ViewPager2 to manage the fragments in the tab system
public class MainPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragmentList;

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragmentList = fragments;
    }

    // returns the fragment instance for the specific tab position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    // returns the total number of tabs
    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}