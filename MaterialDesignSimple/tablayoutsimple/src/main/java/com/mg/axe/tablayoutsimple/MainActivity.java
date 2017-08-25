package com.mg.axe.tablayoutsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Axe on 2017/8/26.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToBase(View view){
        Intent intent = new Intent(MainActivity.this,TabLayoutBasicActivity.class);
        startActivity(intent);
    }

    public void goToViewPager(View view){
        Intent intent = new Intent(MainActivity.this,TabLayoutViewpagerActivity.class);
        startActivity(intent);
    }
}
