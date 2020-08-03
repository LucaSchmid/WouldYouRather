package com.example.wouldyourather;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class QuestionFeed_Fragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    public QuestionFeed_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question_feed_, container, false);
        viewPager = v.findViewById(R.id.pager);
        pagerAdapter = new QuestionFeed_Fragment.ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        return v;
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(QuestionFeed_Fragment fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new fragment_screen_slide_page1();
                case 1:
                    return new fragment_screen_slide_page2();


            }
            return new fragment_screen_slide_page1();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


}