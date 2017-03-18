package com.dou361.jjdxm_demomvp.history.presenter;

import com.dou361.jjdxm_demomvp.base.IBasePresenter;
import com.dou361.jjdxm_demomvp.history.model.HistoryBean;
import com.dou361.jjdxm_demomvp.history.model.HistoryModel;
import com.dou361.jjdxm_demomvp.history.view.IHistoryView;

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
public class HistoryPresenter implements IBasePresenter<IHistoryView> {

    private IHistoryView mView;
    private HistoryModel mModel;

    public HistoryPresenter(IHistoryView view) {
        attachView(view);
        mModel = new HistoryModel(this);
    }

    @Override
    public void attachView(IHistoryView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public void showData(List<HistoryBean> list) {
        mView.dismiss();
        mView.showData(list);
    }

    public void showEmpty() {
        mView.dismiss();
        mView.showEmpty();
    }

    public void showMessage(String msg) {
        mView.showMessage(msg);
    }


    public void searchHistory(String month, String day) {
        mView.showLoading();
        mModel.searchHistory(month, day);
    }
}
