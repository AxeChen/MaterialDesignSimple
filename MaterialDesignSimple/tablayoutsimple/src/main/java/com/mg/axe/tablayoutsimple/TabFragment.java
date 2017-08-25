package com.mg.axe.tablayoutsimple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Axe on 2017/8/26.
 */

public class TabFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int tab = getArguments().getInt("TAB");
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
        textView.setText(tab + "");
        return view;
    }
}
