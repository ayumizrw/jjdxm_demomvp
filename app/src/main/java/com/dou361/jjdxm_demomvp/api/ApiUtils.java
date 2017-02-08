package com.dou361.jjdxm_demomvp.api;

import com.dou361.jjdxm_demomvp.history.model.RepoHistory;
import com.dou361.jjdxm_demomvp.joke.model.RepoJoke;

import java.util.HashMap;
import java.util.Map;

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
 * 描 述：网络接口请求工具类
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ApiUtils extends ApiBase {

    public static Observable<RepoHistory> searchHistory(String month, String day) {
        /**key=7ac7e02ff7f1f8f1ccdc2f9e5dddb6be&v=1.0&month=11&day=1*/
        Map<String, String> map = new HashMap<>();
        map.put("key", "7ac7e02ff7f1f8f1ccdc2f9e5dddb6be");
        map.put("v", "1.0");
        map.put("month", month);
        map.put("day", day);
        return getService().searchHistory(map);
    }

    public static Observable<RepoJoke> loadJoke(String page) {
        /**key=d796a03545bddee0b56d913111f5f199&page=2&pagesize=10&sort=asc&time=1418745237*/
        Map<String, String> map = new HashMap<>();
        map.put("key", "d796a03545bddee0b56d913111f5f199");
        map.put("sort", "asc");
        map.put("time", "1418745237");
        map.put("page", page);
        map.put("pagesize", "10");
        return getService().loadJoke(map);
    }
}
