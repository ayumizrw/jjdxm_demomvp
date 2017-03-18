package com.dou361.jjdxm_demomvp.joke.presenter;

import com.dou361.jjdxm_demomvp.base.IBasePresenter;
import com.dou361.jjdxm_demomvp.joke.model.JokeBean;
import com.dou361.jjdxm_demomvp.joke.model.JokeModel;
import com.dou361.jjdxm_demomvp.joke.view.IJokeView;

import java.util.List;

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
 * 创建日期：2017/2/7
 * <p/>
 * 描 述：View和Model的桥梁，它从Model层检索数据后，返回给View层
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class JokePresenter implements IBasePresenter<IJokeView> {

    private IJokeView mView;
    private JokeModel mModel;

    public JokePresenter(IJokeView view) {
        attachView(view);
        mModel = new JokeModel(this);
    }

    @Override
    public void attachView(IJokeView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public void showData(List<JokeBean> list) {
        mView.dismiss();
        mView.showData(list);
    }

    public void showEmpty() {
        mView.dismiss();
        mView.showEmpty();
    }

    public void checkData(String msg) {
        mView.checkData(msg);
    }

    public void loadJoke(String page) {
        mView.showLoading();
        mModel.loadJoke(page);
    }
}
