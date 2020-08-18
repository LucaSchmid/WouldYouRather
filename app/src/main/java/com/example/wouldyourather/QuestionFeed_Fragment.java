package com.example.wouldyourather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class QuestionFeed_Fragment extends Fragment {

    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private TabLayout tabLayout;

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

        //tab layout connection
        tabLayout = v.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("Beliebteste " );
                                break;
                            case 1:
                                tab.setText("Neueste " );
                                break;
                            case 2:
                                tab.setText("Pervers " );
                                break;
                            case 3:
                                tab.setText("Lustig " );
                                break;
                            default:
                                tab.setText("Kategorie " + (position + 1));
                        }

                    }
                }).attach();

        return v;
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(QuestionFeed_Fragment fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new fragment_screen_slide_page1();
                    case 1:
                        return new fragment_screen_slide_page2();
                    case 2:
                        return new fragment_screen_slide_page3();
                    case 3:
                        return new fragment_screen_slide_page4();
                }

            return new fragment_screen_slide_page2();
        }


        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


}