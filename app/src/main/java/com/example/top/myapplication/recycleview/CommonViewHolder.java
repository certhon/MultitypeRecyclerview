package com.example.top.myapplication.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chenhong on 2017/9/4.
 */

public class CommonViewHolder extends RecyclerView.ViewHolder {


    /**
     * 这个稀疏数组，可以提高效率
     */
    private final SparseArray<View> views;
    private View convertView;


    private Context mContext;

    public CommonViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        convertView = itemView;
        mContext = itemView.getContext();
    }

    /**
     * 返回一个具体的view对象
     *
     *
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int resId, String text) {
        TextView view = getView(resId);
        view.setText(text);
        return this;
    }

    /**
     * 是加载显示图片的
     *
     * @param resId
     * @param url
     */
    public CommonViewHolder setImageByUrl(int resId, String url) {
        ImageView imageView = getView(resId);
//       BitmapUtil.getInstance().display(imageView,url);
        return this;
    }

    /**
     * 条目点击事件
     * @param listener
     * @return
     */
    public CommonViewHolder setOnItemClickListener(View.OnClickListener listener)
    {
        convertView.setOnClickListener(listener);
        return this;
    }

    /**
     * 单个view的点击
     * @param viewId
     * @param listener
     * @return
     */
    public CommonViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener)
    {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
    //自己去定义方法

}
