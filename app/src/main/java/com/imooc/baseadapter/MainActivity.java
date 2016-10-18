package com.imooc.baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.imooc.baseadapter.bean.People;
import com.imooc.baseadapter.utils.CommonAdapter;
import com.imooc.baseadapter.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<People> mDatas = new ArrayList<>();
    private MyAdapter mAdapter;
    private MyAdapterTwo myAdapterTwo;
    private MyAdapterThree myAdapterThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        initViews();

    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.id_listview);
//        mListView.setAdapter(myAdapterThree);

        //不写Adapter，直接用匿名内部类的写法（不提倡原因：这个里面不能写点击事件，很多地方的点击事件没了）
        mListView.setAdapter(new CommonAdapter<People>(MainActivity.this,mDatas) {
            @Override
            public void convert(ViewHolder holder, People people) {
                ((TextView) holder.getView(R.id.id_name)).setText(people.getName());
                ((TextView) holder.getView(R.id.id_age)).setText(people.getAge());
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

//        mAdapter = new MyAdapter(this, mDatas);
//        myAdapterTwo = new MyAdapterTwo(this, mDatas);
//        myAdapterThree = new MyAdapterThree(this, mDatas);

    }


}
