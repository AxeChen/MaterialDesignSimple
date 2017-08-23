package com.mg.axe.toolbarsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //使用代码创建menu
        //menu.add(0, 0, 0, "搜索").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, 0, 0, "搜索").setIcon(android.support.v7.appcompat.R.drawable.abc_ic_search_api_material).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        //使用加载xml文件的方式创建
        getMenuInflater().inflate(R.menu.test_menu, menu);

        //添加子菜单
        menu.addSubMenu(0, 1, 0, "submenu").setIcon(R.mipmap.ic_launcher).addSubMenu(0, 2, 0, "submenu1");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "点击搜索", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "点击submenu", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "submenu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "点击设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:
                Toast.makeText(this, "点击编辑", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "点击分享", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
