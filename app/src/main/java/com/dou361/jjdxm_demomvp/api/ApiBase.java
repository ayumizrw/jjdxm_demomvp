package com.dou361.jjdxm_demomvp.api;

import com.dou361.retrofit2.converter.fastjson.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

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
 * 描 述：网络接口请求基类
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ApiBase {

    /**历史上的今天 http://api.juheapi.com/japi/toh?key=7ac7e02ff7f1f8f1ccdc2f9e5dddb6be&v=1
     * .0&month=11&day=1*/
    /** 笑话大全 http://japi.juhe.cn/joke/content/list
     * .from?key=d796a03545bddee0b56d913111f5f199&page=2&pagesize=10&sort=asc&time=1418745237 */
    protected static IApiService getService() {
        return getService(null);
    }

    protected static IApiService getService(String ip) {
        return getService(ip, 0, 0);
    }

    protected static IApiService getService(String ip, long readTime, long connectTime) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(readTime <= 0 ? 30 : readTime, TimeUnit.SECONDS)
                .connectTimeout(connectTime <= 0 ? 30 : connectTime, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ip == null ? "http://api.juheapi.com" : ip)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        return retrofit.create(IApiService.class);
    }
}
