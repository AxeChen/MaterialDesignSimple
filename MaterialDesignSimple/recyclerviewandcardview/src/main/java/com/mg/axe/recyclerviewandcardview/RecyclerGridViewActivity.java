package com.mg.axe.recyclerviewandcardview;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Axe on 2017/8/24.
 */

public class RecyclerGridViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Integer> items = new ArrayList<>();

    private LayoutInflater mInflater;

    private int imgWidth = 0;

    private ViewGroup.LayoutParams layoutParams;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initData();
        imgWidth = getScreenWidth()[0] / 3;
        layoutParams = new ViewGroup.LayoutParams(imgWidth, imgWidth);
        recyclerView.setAdapter(new RecyclerGridViewActivity.MyAdapter());
    }

    private void initView() {
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 设置GridLayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        items.add(R.mipmap.one);
        items.add(R.mipmap.two);
        items.add(R.mipmap.three);
        items.add(R.mipmap.four);
        items.add(R.mipmap.five);
        items.add(R.mipmap.six);
        items.add(R.mipmap.seven);
        items.add(R.mipmap.eight);
        items.add(R.mipmap.nine);
        items.add(R.mipmap.ten);
        items.add(R.mipmap.eleven);
        items.add(R.mipmap.one);
        items.add(R.mipmap.two);
        items.add(R.mipmap.three);
        items.add(R.mipmap.four);
    }

    private class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerGridViewActivity.ItemViewHolder(mInflater.inflate(R.layout.item_grid, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            bindItemViewHolder((ItemViewHolder) holder, position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

    }

    public void bindItemViewHolder(ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.imageView.setImageResource(items.get(position));
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivImg);
            imageView.setLayoutParams(layoutParams);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


    public int[] getScreenWidth() {
        WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        int[] size = new int[2];
        size[0] = width;
        size[1] = height;
        return size;
    }

}
