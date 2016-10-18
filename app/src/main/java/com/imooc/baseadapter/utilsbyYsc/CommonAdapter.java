package com.imooc.baseadapter.utilsbyYsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 鸿洋制作，提取了R.layout.item（子项布局）
 * Created by ysc on 10/18/2016.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    /**传入数据*/
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    /**子项布局*/
    protected int mItemLayoutId;

    public CommonAdapter(Context context, int itemLayoutId, List<T> datas) {
        mContext = context;
        mItemLayoutId = itemLayoutId;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);

        convert(holder, (T) getItem(position));

        return holder.getmConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);
}
