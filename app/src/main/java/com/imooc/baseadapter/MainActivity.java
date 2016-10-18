package com.imooc.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.imooc.baseadapter.bean.People;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<People> mDatas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();
    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.id_listview);
    }

    private void initDatas() {
        People people = new People("Kim", "12");
        mDatas.add(people);
        people = new People("Kim", "12");
        mDatas.add(people);
        people = new People("Kim", "12");
        mDatas.add(people);
        people = new People("Kim", "12");
        mDatas.add(people);
        people = new People("Kim", "12");
        mDatas.add(people);
    }


}
