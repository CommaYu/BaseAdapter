package com.imooc.baseadapter.utilsbyYsc;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 鸿洋制作
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

    /**在convertView复用问题中，终于用到了Position*/
    public int getPostion() {
        return mPostion;
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

    ////////////////以下全部是辅助方法，看我们listview里面的item定的。如果是文字就用setText、图片就用setImagexxx
    //如果有辅助方法就用辅助方法，没有辅助方法就用原来的((TextView) holder.getView(R.id.id_age)).setText(people.getAge());

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 加载本地图片
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * 加载本地位图
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 加载网络图片（通过Imageloader进行加载）
     *
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageURI(int viewId, String url) {
        ImageView iv = getView(viewId);
        //Imageloader.load(view,url);
        //Imageloader.getInstance().loadImg(view,url);
        return this;
    }

}
