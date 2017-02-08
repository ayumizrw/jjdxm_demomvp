package com.dou361.jjdxm_demomvp.history.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dou361.jjdxm_demomvp.R;
import com.dou361.jjdxm_demomvp.base.BaseMVPActivity;
import com.dou361.jjdxm_demomvp.history.model.HistoryBean;
import com.dou361.jjdxm_demomvp.history.presenter.HistoryPresenter;
import com.dou361.jjdxm_demomvp.history.view.IHistoryView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
 * 创建日期：2017/2/8 13:40
 * <p/>
 * 描 述：历史的今天
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class HistoryActivity extends BaseMVPActivity<IHistoryView, HistoryPresenter> implements
        IHistoryView {

    @BindView(R.id.et_month)
    EditText etMonth;
    @BindView(R.id.et_day)
    EditText etDay;
    @BindView(R.id.rlv_history)
    RecyclerView rlvHistory;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public HistoryPresenter createPresenter() {
        return new HistoryPresenter(this);
    }

    @Override
    public void showData(List<HistoryBean> list) {
        llEmpty.setVisibility(View.GONE);
        rlvHistory.setLayoutManager(new LinearLayoutManager(this));// 布局管理器。
        rlvHistory.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        rlvHistory.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        adapter = new HistoryAdapter(this, list);
        rlvHistory.setAdapter(adapter);
    }

    @Override
    public void showEmpty() {
        llEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismiss() {
        llLoading.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        getPresenter().searchHistory(etMonth.getText().toString(), etDay.getText().toString());
    }
}
