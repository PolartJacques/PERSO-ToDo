package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // DECLARE VARIABLES
    private ViewPager2 viewPager;
    private Fragment[] fragments;
    private FragmentStateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INITIALIZE VARIABLES
        viewPager = findViewById(R.id.viewPager);
        fragments = new Fragment[] {new LoginFragment(), new RegisterFragment()};
        adapter = new ViewPagerAdapter(this, fragments);

        // INIT
        viewPager.setAdapter(adapter);

        // get information from the fragments of the viewPager
        getSupportFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                String result = bundle.getString("bundleKey");
                if(result.equals("register")) {
                    // go to register form
                    viewPager.setCurrentItem(1);
                }
                if(result.equals("login")) {
                    // go to login form
                    viewPager.setCurrentItem(0);
                }
            }
        });
    }



    // ADAPTER CLASS FOR THE VIEW PAGER
    private class ViewPagerAdapter extends FragmentStateAdapter {

        private Fragment[] fragments;

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Fragment[] fragments) {
            super(fragmentActivity);
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments[position];
        }

        @Override
        public int getItemCount() {
            return fragments.length;
        }
    }
}