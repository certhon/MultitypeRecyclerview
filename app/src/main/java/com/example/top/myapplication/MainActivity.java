package com.example.top.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.top.myapplication.recycleview.BaseViewHolder;
import com.example.top.myapplication.recycleview.ItemViewDelegate;
import com.example.top.myapplication.recycleview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        List datas = new ArrayList();

        datas.add(new Person("小明"));
        datas.add(new animal("18"));
        datas.add(new Person("大啊"));
        datas.add(new animal("19"));
        datas.add(new Person("第三方"));
        datas.add(new animal("25"));
        datas.add(new Person("大"));
        datas.add(new animal("75"));
        datas.add(new Person("好的"));
        datas.add(new animal("45"));

        MultiItemTypeAdapter multiItemTypeAdapter = new MultiItemTypeAdapter(this,datas);
        multiItemTypeAdapter.addItemViewDelegate(1, new ItemViewDelegate() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.person;
            }

            @Override
            public boolean isForViewType(Object item, int position) {
                return item instanceof Person;
            }

            @Override
            public void convert(BaseViewHolder holder, Object o, int position) {
                Person person = (Person)o;
                holder.setText(R.id.tv, person.getName());
            }
        });
        multiItemTypeAdapter.addItemViewDelegate(2, new ItemViewDelegate() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.animal;
            }

            @Override
            public boolean isForViewType(Object item, int position) {
                return item instanceof animal;
            }

            @Override
            public void convert(BaseViewHolder holder, Object item, int position) {
                animal manimal = (animal)item;
                holder.setText(R.id.tv, manimal.getAge());
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(this
        ));
        recyclerview.setAdapter(multiItemTypeAdapter);
    }
}
