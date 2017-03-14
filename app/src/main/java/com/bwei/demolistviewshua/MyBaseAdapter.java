package com.bwei.demolistviewshua;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
*1.类的用途
*2.zhanghaisheng
*3.2017/3/14
**/

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> list;
    private Bean item;
    private ViewHolder v;
    public MyBaseAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        v = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item, null);
            v = new ViewHolder();
            v.check = (CheckBox) view.findViewById(R.id.check);
            v.textview = (TextView) view.findViewById(R.id.textviewa);
            view.setTag(v);
        } else {
            v = (ViewHolder) view.getTag();
        }
        v.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    list.get(i).flag = b;

                } else {
                    list.get(i).flag = false;
                }
            }
        });
        item = list.get(i);
        v.textview.setText(item.name);
        v.check.setChecked(item.flag);
        return view;
    }

    class ViewHolder {
        CheckBox check;
        TextView textview;
    }

}
