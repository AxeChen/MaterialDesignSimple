package com.mg.axe.snackbarsimple;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup radioGroup;

    private static final int TYPE_ONE = R.id.rbOne;
    private static final int TYPE_TWO = R.id.rbTwo;
    private static final int TYPE_THREE = R.id.rbThree;
    private static final int TYPE_FOUR = R.id.rbFour;
    private static final int TYPE_FIVE = R.id.rbFive;

    private int type = TYPE_ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.rbGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                type = checkedId;
            }
        });
    }

    public void showSnackbar(View view) {
        switch (type) {
            case TYPE_ONE:
                Snackbar.make(button, "第一次使用SnackBar", Snackbar.LENGTH_SHORT).show();
                break;
            case TYPE_TWO:
                Snackbar.make(button, "第一次使用SnackBar", Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
            case TYPE_THREE:
                Snackbar.make(button, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
            case TYPE_FOUR:
                Snackbar.make(button, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).addCallback(new Snackbar.Callback() {
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        Toast.makeText(MainActivity.this, "弹出了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(MainActivity.this, "消失了", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;

            case TYPE_FIVE:
                Snackbar snackbar = Snackbar.make(button, "第一次使用SnackBar", Snackbar.LENGTH_INDEFINITE).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.setActionTextColor(Color.GREEN);
                snackbar.getView().setBackgroundResource(R.color.colorPrimaryDark);
                /* snackbar 并没有提供修改提示文字颜色的方法。不过可以通过找到snackbar的布局design_layout_snackbar_include
                   通过布局可以找到textview的id。
                   在通过snackbar.getView().findViewById(R.id.snackbar_text);
                 */
                TextView textView = (TextView) snackbar.getView().findViewById(R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
                snackbar.show();
                break;
        }

    }
}
