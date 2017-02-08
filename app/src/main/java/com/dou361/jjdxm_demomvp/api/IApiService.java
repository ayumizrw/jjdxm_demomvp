package com.dou361.jjdxm_demomvp.api;


import com.dou361.jjdxm_demomvp.history.model.RepoHistory;
import com.dou361.jjdxm_demomvp.joke.model.RepoJoke;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

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
 * 描 述：网络接口请求服务类
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface IApiService {

    /** 查询历史的今天 */
    @GET("/japi/toh")
    Observable<RepoHistory> searchHistory(@QueryMap Map<String, String> map);

    /** 加载笑话列表 */
    @GET("/joke/content/list.from")
    Observable<RepoJoke> loadJoke(@QueryMap Map<String, String> map);
}
