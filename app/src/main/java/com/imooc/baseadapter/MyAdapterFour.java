package com.imooc.baseadapter;

import android.content.Context;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;
import com.imooc.baseadapter.utilsbyYsc.CommonAdapter;
import com.imooc.baseadapter.utilsbyYsc.ViewHolder;

import java.util.List;

/**
 * Created by ysc on 10/18/2016.
 */

public class MyAdapterFour extends CommonAdapter<People> {
    public MyAdapterFour(Context context, int itemLayoutId, List<People> datas) {
        super(context, itemLayoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, People people) {
        holder.setText(R.id.id_name, people.getName());//辅助方法不可能方方面面都做到，没有的还是得靠自己

        ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());
    }
}
