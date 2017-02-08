package com.dou361.jjdxm_demomvp.history.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.dou361.jjdxm_demomvp.R;
import com.dou361.jjdxm_demomvp.history.model.HistoryBean;
import com.dou361.recyclerview.hodler.BaseViewHolder;
import com.dou361.recyclerview.listener.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ========================================
 * <p/>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p/>
 * 作 者：陈冠明
 * <p/>
 * 个人网站：http://www.dou361.com
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2016/3/10
 * <p/>
 * 描 述：
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class HistoryItemHolder extends BaseViewHolder<HistoryBean> {

    @BindView(R.id.tv_lunar)
    TextView tvLunar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    public HistoryItemHolder(Context mContext, OnItemClickListener listener, View itemView) {
        super(mContext, listener, itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void refreshView() {
        HistoryBean mData = getData();
        tvLunar.setText(mData.getLunar());
        tvTitle.setText(mData.getTitle());
        tvContent.setText(mData.getDes());
    }

}
