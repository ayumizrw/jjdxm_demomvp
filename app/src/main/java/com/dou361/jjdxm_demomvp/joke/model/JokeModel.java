package com.dou361.jjdxm_demomvp.joke.model;

import android.text.TextUtils;

import com.dou361.jjdxm_demomvp.api.ApiUtils;
import com.dou361.jjdxm_demomvp.base.BaseModel;
import com.dou361.jjdxm_demomvp.joke.presenter.IJokePresenter;

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
public class JokeModel extends BaseModel<IJokePresenter> {

    public JokeModel(IJokePresenter iPresenter) {
        super(iPresenter);
    }

    public void loadJoke(String page) {
        if (TextUtils.isEmpty(page)) {
            mIPresenter.checkData("页数不能为空");
            return;
        }
        int iPage = Integer.valueOf(page).intValue();
        if (iPage <= 0) {
            mIPresenter.checkData("只能输入大于0的页数");
            return;
        }
        ApiUtils.loadJoke(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<RepoJoke>() {
                    @Override
                    public void call(RepoJoke repoJoke) {
                        if (repoJoke == null || repoJoke.getResult() == null
                                || repoJoke.getResult().getData() == null
                                || repoJoke.getResult().getData().size() <= 0) {
                            mIPresenter.showEmpty();
                        } else {
                            mIPresenter.showData(repoJoke.getResult().getData());
                        }
                    }
                });
    }
}
