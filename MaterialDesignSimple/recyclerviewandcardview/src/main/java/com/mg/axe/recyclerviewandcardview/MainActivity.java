package com.mg.axe.recyclerviewandcardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Axe on 2017/8/24.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toListView(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerListViewActivity.class);
        startActivity(intent);
    }

    public void toGridView(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerGridViewActivity.class);
        startActivity(intent);
    }

}
