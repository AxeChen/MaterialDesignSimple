package com.mg.axe.bottomsheetsimple;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.llBottom);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);
    }

    public void OpenBottomBehavior(View view) {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public void OpenBottomSheetDialogFragment(View view) {
        MyBottomSheetDialogFragment dialogFragment = new MyBottomSheetDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "MyBottomSheetDialogFragment");
    }

    public void OpenBottomSheetDialog(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.dialog_bottom);
        bottomSheetDialog.show();
    }
}
