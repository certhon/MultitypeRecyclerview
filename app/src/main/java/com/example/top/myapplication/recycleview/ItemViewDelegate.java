package com.example.top.myapplication.recycleview;

/**
 * Created by chenhong on 2017/10/16.
 */

public interface ItemViewDelegate<T> {
    //向 Adapter 提供布局文件的 id
    int getItemViewLayoutId();

    //判断传入的 item 是不是自己应该处理的类型
    boolean isForViewType(T item, int position);

    //绑定 holder 和数据
    void convert(BaseViewHolder holder, T t, int position);
}

