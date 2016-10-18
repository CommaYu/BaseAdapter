package com.imooc.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;

import java.util.List;

/**
 * Created by ysc on 10/18/2016.
 */

public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<People> mDatas;

    public MyAdapter(Context context, List<People> datas) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_people, parent, false);

            holder = new ViewHolder();
            holder.mName = (TextView) convertView.findViewById(R.id.id_name);
            holder.mAge = (TextView) convertView.findViewById(R.id.id_age);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        People people = mDatas.get(position);
        holder.mName.setText(people.getName());
        holder.mAge.setText(people.getAge());
        return convertView;
    }

    private class ViewHolder {
        TextView mName;
        TextView mAge;
    }
}
