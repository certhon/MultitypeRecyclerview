package com.example.top.myapplication.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by chenhong on 2017/9/4.
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    /**
     * 这里我我们是提取的公共的，所以我们在这用泛型T，而不是给出具体的值，具体的交给我们的实现类去传入
     */
    private List<T> mTList;
    //布局id
    private int layoutId;


    /**
     * 这里构造函数，传入数据的list和布局
     *
     * @param TList
     * @param layoutId
     */
    public CommonAdapter(List<T> TList, int layoutId) {
        mTList = TList;
        this.layoutId = layoutId;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutId, null);
        return new CommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        convert(holder, mTList.get(position),position);
    }

    /**
     * 留给调用者去实现
     *
     * @param holder
     * @param t
     */
    public abstract void convert(CommonViewHolder holder, T t,int positon) ;

    @Override
    public int getItemCount() {
        return mTList.size();
    }

    /**
     * 刷新数据
     * @param TList
     */
    public void refreshData(List<T> TList) {
        this.mTList = TList;
        notifyDataSetChanged();
    }
}
