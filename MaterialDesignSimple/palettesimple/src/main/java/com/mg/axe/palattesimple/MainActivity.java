package com.mg.axe.palattesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Axe on 2017/9/10.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void basicUse(View view) {
        Intent intent = new Intent(MainActivity.this, PalettesBasicActivity.class);
        startActivity(intent);
    }

    public void simpleUse(View view) {
        Intent intent = new Intent(MainActivity.this, TabLayoutViewpagerActivity.class);
        startActivity(intent);
    }
}
