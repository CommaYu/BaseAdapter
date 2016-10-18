package com.imooc.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;
import com.imooc.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by ysc on 10/18/2016.
 */

public class MyAdapterTwo extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<People> mDatas;
    private Context mContext;

    public MyAdapterTwo(Context context, List<People> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();//获取数据集的长度
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);//获取数据集的某一个item
    }

    @Override
    public long getItemId(int position) {
        return position;//直接返回item的id值
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, R.layout.item_people, position);

        People people = mDatas.get(position);

        ((TextView) holder.getView(R.id.id_name)).setText(people.getName());

        ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());

        return holder.getmConvertView();
    }

}
