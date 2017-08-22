package com.mg.axe.toolbarsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        setToolbarProperty();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setToolbarProperty() {
        // 设置正标题
        toolbar.setTitle("正标题");
        // 设置副标题
        toolbar.setSubtitle("副标题");
        // 设置左边按钮图片
        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
        // 设置标题与左边按钮之间图标
        toolbar.setLogo(R.mipmap.ic_launcher);
        // 点击左侧按钮监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了Navigation按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
