package com.example.wouldyourather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottonNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new QuestionFeed_Fragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottonNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.button_Menu_MyQuestions:
                            fragment = new MyQuestion_Fragment();
                            break;
                        case R.id.button_Menu_newQuestion:
                            fragment = new newQuestion_Fragment();
                            break;
                        case R.id.button_Menu_Questionsfeed:
                            fragment = new QuestionFeed_Fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1,fragment).commit();
                    return true;
                }
            };

}