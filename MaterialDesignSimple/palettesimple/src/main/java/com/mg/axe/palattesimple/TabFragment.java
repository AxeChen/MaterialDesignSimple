package com.mg.axe.palattesimple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Axe on 2017/8/26.
 */

public class TabFragment extends Fragment {

    private Bitmap bitmap;
    private TextView tvBG;
    private TextView tvDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int tab = getArguments().getInt("TAB");
        View view = inflater.inflate(R.layout.fragment, container, false);
        tvBG = (TextView) view.findViewById(R.id.tvBg);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivImg);
        if (tab == 1) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jt);
            tvDescription.setText("你说你喜欢听吉他，我就在你回家的路上弹吉他等你。");
        } else if (tab == 2) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fx);
            tvDescription.setText("那燃烧的枫叶，都比不过我对远方的期盼。");
        } else if (tab == 3) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xsea);
            tvDescription.setText("期待有一天我能和你\"面朝大海，春暖花开。\"");
        } else if (tab == 4) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pg);
            tvDescription.setText("说好要一起旅行，是你如今，唯一坚持的任性。");
        }
        imageView.setImageBitmap(bitmap);
        return view;
    }

    public void setContent(int rgb) {
        tvBG.setBackgroundColor(rgb);
        tvBG.setAlpha((float) 0.5);
    }

    public Bitmap getBitmap() {

        return bitmap;
    }
}
