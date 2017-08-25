package com.mg.axe.tablayoutsimple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axe on 2017/8/26.
 */

public class TabLayoutViewpagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        initFragments();
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragments() {
        TabFragment tab1 = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TAB", 1);
        tab1.setArguments(bundle);

        TabFragment tab2 = new TabFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("TAB", 2);
        tab2.setArguments(bundle2);

        TabFragment tab3 = new TabFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("TAB", 3);
        tab3.setArguments(bundle3);


        TabFragment tab4 = new TabFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("TAB", 4);
        tab4.setArguments(bundle4);

        fragments.add(tab1);
        fragments.add(tab2);
        fragments.add(tab3);
        fragments.add(tab4);
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "第" + (position + 1) + "页";
        }
    }


}
