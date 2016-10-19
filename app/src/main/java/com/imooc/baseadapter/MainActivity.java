package com.imooc.baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<People> mDatas = new ArrayList<>();
    private MyAdapter mAdapter;
    private MyAdapterTwo myAdapterTwo;
    private MyAdapterThree myAdapterThree;
    private MyAdapterFour myAdapterFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initViews();

    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.id_listview);

        //1、最常见的MyAdapter的写法和运用
        //        mAdapter = new MyAdapter(this, mDatas);
        //        mListView.setAdapter(mAdapter);

        //只提取了ViewHolder的MyAdapter写法
        //        myAdapterTwo = new MyAdapterTwo(this, mDatas);
        //        mListView.setAdapter(myAdapterTwo);

        //2、提取了Viewholder和提取成CommonAdapter的写法
        //        myAdapterThree = new MyAdapterThree(this, mDatas);
        //        mListView.setAdapter(myAdapterThree);


        //3、不单独写Adapter，直接用匿名内部类的写法（不提倡原因：这个里面不能写点击事件，很多地方的点击事件没了）
        /*mListView.setAdapter(new CommonAdapter<People>(MainActivity.this, mDatas) {
            @Override
            public void convert(ViewHolder holder, People people) {
                ((TextView) holder.getView(R.id.id_name)).setText(people.getName());
                ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());
            }
        });*/

        /*mListView.setAdapter(new com.imooc.baseadapter.utilsbyYsc.CommonAdapter<People>(MainActivity.this,R.layout.item_people,mDatas) {
            @Override
            public void convert(com.imooc.baseadapter.utilsbyYsc.ViewHolder holder, People people) {
                ((TextView) holder.getView(R.id.id_name)).setText(people.getName());
                ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());
            }
        });*/

//        myAdapterFour = new MyAdapterFour(MainActivity.this, R.layout.item_people, mDatas);
//        mListView.setAdapter(myAdapterFour);

        // 演示解决convertView复用问题
        mListView.setAdapter(new com.imooc.baseadapter.utilsbyYsc.CommonAdapter<People>(MainActivity.this,R.layout.item_people,mDatas) {
            @Override
            public void convert(com.imooc.baseadapter.utilsbyYsc.ViewHolder holder, final People people) {
                ((TextView) holder.getView(R.id.id_name)).setText(people.getName());
                ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());

                final CheckBox cb = holder.getView(R.id.id_cb);
                cb.setChecked(people.isChecked());
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        people.setChecked(cb.isChecked());
                    }
                });
            }
        });
    }

    private void initDatas() {
        People people = new People("Kim0", "12");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);
        people = new People("Kim1", "13");
        mDatas.add(people);
        people = new People("Kim2", "14");
        mDatas.add(people);
        people = new People("Kim3", "15");
        mDatas.add(people);
        people = new People("Kim4", "16");
        mDatas.add(people);


    }


}
