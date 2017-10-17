package com.example.top.myapplication.recycleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by chenhong on 2017/10/16.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    //类似HashMap Android用SparseArray性能更高
    //管理view
    private SparseArray<View> mViews;
    //学习过ListView性能优化的肯定知道 这是缓存视图的
    private View mConvertView;
    private Context mContext;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static BaseViewHolder createViewHolder(Context context, View itemView) {
        return new BaseViewHolder(context, itemView);
    }

    public static BaseViewHolder createViewHolder(Context context,
                                                  ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        return new BaseViewHolder(context, itemView);
    }

    /**
     * 通过ViewId获取控件
     *
     * @author dyb
     * @createTime 2017/3/17 22:54
     */
    public <T extends View> T getView(int viewId) {
        //先去SparseArray取view
        View view = mViews.get(viewId);//viewId 指的是 R.id.XXX这种 对应一个viewId
        if (view == null) {
            view = mConvertView.findViewById(viewId);//SparseArray中没有 则到convertView中直接findViewById
            mViews.put(viewId, view);//把view放进SparseArray中
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    //以下为辅助方法（可略看）

    //设置TextView内容
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    //设置ImageView资源
    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    //设置ImageView图片Url
    public BaseViewHolder setImageUrl(int viewId, String imgUrl) {
        ImageView view = getView(viewId);
        //BitmapUtil.getInstance().display(view,imgUrl);
        return this;
    }

    //设置ImageView图片Bitmap
    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    //设置ImageView图片Drawable
    public BaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    //事件监听
    public BaseViewHolder setOnClickListener(int viewId,
                                             View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }


}