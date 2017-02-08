package com.dou361.jjdxm_demomvp.joke.ui;

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
import com.dou361.jjdxm_demomvp.joke.model.JokeBean;
import com.dou361.jjdxm_demomvp.joke.presenter.JokePresenter;
import com.dou361.jjdxm_demomvp.joke.view.IJokeView;

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
public class JokeActivity extends BaseMVPActivity<IJokeView, JokePresenter> implements
        IJokeView {

    @BindView(R.id.et_page)
    EditText etPage;
    @BindView(R.id.rlv_joke)
    RecyclerView rlvJoke;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    private JokeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public JokePresenter createPresenter() {
        return new JokePresenter(this);
    }

    @Override
    public void showData(List<JokeBean> list) {
        llEmpty.setVisibility(View.GONE);
        rlvJoke.setLayoutManager(new LinearLayoutManager(this));// 布局管理器。
        rlvJoke.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        rlvJoke.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        adapter = new JokeAdapter(this, list);
        rlvJoke.setAdapter(adapter);
    }

    @Override
    public void showEmpty() {
        llEmpty.setVisibility(View.VISIBLE);
    }

    @Override
    public void checkData(String msg) {
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

    @OnClick(R.id.btn_load)
    public void onClick() {
        getPresenter().loadJoke(etPage.getText().toString());
    }
}
