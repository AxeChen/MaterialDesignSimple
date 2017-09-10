package com.mg.axe.palattesimple;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axe on 2017/8/26.
 */

public class TabLayoutViewpagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TabFragment tab1;
    private TabFragment tab2;
    private TabFragment tab3;
    private TabFragment tab4;

    private Toolbar toolbar;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initActionBar();
        initFragments();
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        addPageChangeListener();
//        viewPager.setCurrentItem(0);

    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
    }


    private void initFragments() {
        tab1 = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TAB", 1);
        tab1.setArguments(bundle);

        tab2 = new TabFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("TAB", 2);
        tab2.setArguments(bundle2);

        tab3 = new TabFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("TAB", 3);
        tab3.setArguments(bundle3);


        tab4 = new TabFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("TAB", 4);
        tab4.setArguments(bundle4);

        fragments.add(tab1);
        fragments.add(tab2);
        fragments.add(tab3);
        fragments.add(tab4);
    }

    private boolean isInit = false;

    private void addPageChangeListener() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 这个方法在setAdapter之后会调用一次，在这里初始化第一个界面，而且只调用一次
                if (!isInit) {
                    isInit = true;
                    setPaletteColor(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                setPaletteColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setPaletteColor(final int position) {
        Bitmap bitmap = null;
        if (position == 0) {
            bitmap = tab1.getBitmap();
        } else if (position == 1) {
            bitmap = tab2.getBitmap();
        } else if (position == 2) {
            bitmap = tab3.getBitmap();
        } else if (position == 3) {
            bitmap = tab4.getBitmap();
        }
        if (bitmap == null) {
            return;
        }
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
//                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);
//                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
//                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
//                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
//                int vibrantColor = palette.getVibrantColor(Color.BLUE);
//                int mutedColor = palette.getMutedColor(Color.BLUE);

                // 设置TabLayout颜色(直接设置颜色)
//                tabLayout.setBackgroundColor(vibrantColor);
//                toolbar.setBackgroundColor(vibrantColor);
                //

                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if (vibrant == null) {
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        vibrant = swatch;
                        break;
                    }
                }
                // 这样获取的颜色可以进行改变。
                int rbg = vibrant.getRgb();

                if (position == 0) {
                    tab1.setContent(rbg);
                } else if (position == 1) {
                    tab2.setContent(rbg);
                } else if (position == 2) {
                    tab3.setContent(rbg);
                } else if (position == 3) {
                    tab4.setContent(rbg);
                }

                tabLayout.setBackgroundColor(rbg);
                toolbar.setBackgroundColor(rbg);
                if (Build.VERSION.SDK_INT > 21) {
                    Window window = getWindow();
                    //状态栏改变颜色。
                    int color = changeColor(rbg);
                    window.setStatusBarColor(color);
                }

            }
        });
    }

    private int changeColor(int rgb) {
        int red = rgb >> 16 & 0xFF;
        int green = rgb >> 8 & 0xFF;
        int blue = rgb & 0xFF;
        red = (int) Math.floor(red * (1 - 0.2));
        green = (int) Math.floor(green * (1 - 0.2));
        blue = (int) Math.floor(blue * (1 - 0.2));
        return Color.rgb(red, green, blue);
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
