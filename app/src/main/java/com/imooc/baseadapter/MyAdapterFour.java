package com.imooc.baseadapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.imooc.baseadapter.bean.People;
import com.imooc.baseadapter.utilsbyYsc.CommonAdapter;
import com.imooc.baseadapter.utilsbyYsc.ViewHolder;

import java.util.List;

/**
 * Created by ysc on 10/18/2016.
 */

public class MyAdapterFour extends CommonAdapter<People> {
    private Context mContext;
    public MyAdapterFour(Context context, int itemLayoutId, List<People> datas) {
        super(context, itemLayoutId, datas);
        mContext = context;
    }

    @Override
    public void convert(ViewHolder holder, People people) {
        holder.setText(R.id.id_name, people.getName());//辅助方法不可能方方面面都做到，没有的还是得靠自己

        ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());

        final TextView tv_name = holder.getView(R.id.id_name);
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, tv_name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
