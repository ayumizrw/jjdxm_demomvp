package com.dou361.jjdxm_demomvp.joke.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dou361.jjdxm_demomvp.R;
import com.dou361.jjdxm_demomvp.joke.model.JokeBean;
import com.dou361.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.dou361.recyclerview.hodler.BaseViewHolder;

import java.util.List;

/**
 * ========================================
 * <p>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p>
 * 作 者：陈冠明
 * <p>
 * 个人网站：http://www.dou361.com
 * <p>
 * 版 本：1.0
 * <p>
 * 创建日期：2016/3/10
 * <p>
 * 描 述：粉丝列表
 * <p>
 * <p>
 * 修订历史：
 * <p>
 * ========================================
 */
public class JokeAdapter extends BaseRecyclerViewAdapter<JokeBean> {

    public JokeAdapter(Context mContext, List<JokeBean> mDatas) {
        super(mContext, mDatas);
    }


    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(mContext).
                inflate(R.layout.holder_item_joke, parent, false);
    }

    @Override
    public BaseViewHolder getItemHolder(View contentView, int viewType) {
        return new JokeItemHolder(mContext, mListener, contentView);
    }
}
