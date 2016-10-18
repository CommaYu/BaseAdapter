package com.imooc.baseadapter;

import android.content.Context;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;
import com.imooc.baseadapter.utils.CommonAdapter;
import com.imooc.baseadapter.utils.ViewHolder;

import java.util.List;

/**
 * Created by ysc on 10/18/2016.
 */

public class MyAdapterThree extends CommonAdapter<People> {


    public MyAdapterThree(Context context, List<People> datas) {
        super(context, datas);
    }


    @Override
    public void convert(ViewHolder holder, People people) {

//        ((TextView) holder.getView(R.id.id_name)).setText(people.getName());
        holder.setText(R.id.id_name, people.getName());//辅助方法不可能方方面面都做到，没有的还是得靠自己

        ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());
    }

}
