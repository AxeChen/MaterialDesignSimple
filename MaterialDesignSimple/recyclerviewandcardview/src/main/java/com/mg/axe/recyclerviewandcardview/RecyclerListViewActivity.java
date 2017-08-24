package com.mg.axe.recyclerviewandcardview;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerListViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> items = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initData();
        recyclerView.setAdapter(new MyAdapter());
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 设置LinearLayoutManager
        // 设置水平滑动：
        // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //设置垂直滑动
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        items.add("一花一世界");
        items.add("专家说：蚂蚁可以拯救世界！");
        items.add("一花一世界");
        items.add("专家说：蚂蚁可以拯救世界！");
        items.add("一花一世界");
    }

    private class MyAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(RecyclerListViewActivity.this).inflate(R.layout.item_list, parent, false));
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

    public void bindItemViewHolder(RecyclerListViewActivity.ItemViewHolder itemViewHolder, int position) {

        // 从list中获取值
        itemViewHolder.tvTitle.setText(items.get(position));

        //description为模拟的值因为 items 只有title的值
        int res = 0;
        String description = "";
        if (position % 2 == 0) {
            res = R.drawable.huahua;
            description = "一朵花就是一个宇宙。一个人身也是一个宇宙。万物渺小或者宏大，微观世界或者宏观世界，都是一个世界。";
        } else {
            res = R.drawable.mayi;
            description = "专家说：蚂蚁会在夜深人静的时候变成蚂蚁侠，他们的任务就是拯救世界！";
        }
        itemViewHolder.imageView.setImageResource(res);
        itemViewHolder.tvDescription.setText(description);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvDescription;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivImg);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //设置点击事件
                    int index = getAdapterPosition();
                    if (index >= 0) {
                        // 点击item执行的代码
                    }
                }
            });
        }
    }


}
