package com.imooc.baseadapter.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ysc on 10/18/2016.
 */

public class ViewHolder {
    private SparseArray<View> mViews;//用SparseArray是因为比Map效率更高
    private int mPostion;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPostion = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);

    }

    // 由于convertView有时候是存在的，不一定要每个都new ViewHolder，所以我们写了一个直接得到ViewHolder的get的入口
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            //如果convertView是空的时候，就重新new一个ViewHolder
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            //如果已经存在了，就直接get方法
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPostion = position; //虽然是复用了，但是我们还是需要更新一下它的位置
            return holder;
        }

    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getmConvertView() {
        return mConvertView;
    }

}
