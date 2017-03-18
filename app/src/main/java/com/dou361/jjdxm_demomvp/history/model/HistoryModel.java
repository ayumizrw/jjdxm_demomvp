package com.dou361.jjdxm_demomvp.history.model;

import android.text.TextUtils;

import com.dou361.jjdxm_demomvp.api.ApiUtils;
import com.dou361.jjdxm_demomvp.base.BaseModel;
import com.dou361.jjdxm_demomvp.history.presenter.HistoryPresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
 * 创建日期：2017/2/8 14:00
 * <p/>
 * 描 述：业务具体处理，包括负责存储、检索、操纵数据等
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class HistoryModel extends BaseModel<HistoryPresenter> {

    public HistoryModel(HistoryPresenter presenter) {
        super(presenter);
    }

    public void searchHistory(String month, String day) {
        if (TextUtils.isEmpty(month)) {
            mIPresenter.showMessage("月份不能为空");
            return;
        }
        int iMonth = Integer.valueOf(month).intValue();
        if (iMonth <= 0 || iMonth > 12) {
            mIPresenter.showMessage("只能输入1-12的月份");
            return;
        }
        if (TextUtils.isEmpty(day)) {
            mIPresenter.showMessage("天不能为空");
            return;
        }
        int iDay = Integer.valueOf(day).intValue();
        if (iDay <= 0 || iDay > 31) {
            mIPresenter.showMessage("只能输入1-31的天");
            return;
        }
        ApiUtils.searchHistory(month, day)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<RepoHistory>() {
                    @Override
                    public void call(RepoHistory repoHistory) {
                        if (repoHistory == null || repoHistory.getResult() == null
                                || repoHistory.getResult().size() <= 0) {
                            mIPresenter.showEmpty();
                        } else {
                            mIPresenter.showData(repoHistory.getResult());
                        }
                    }
                });
    }
}
