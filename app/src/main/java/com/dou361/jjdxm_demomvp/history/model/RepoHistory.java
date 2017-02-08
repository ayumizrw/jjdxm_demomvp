package com.dou361.jjdxm_demomvp.history.model;

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
 * 创建日期：2017/2/8 14:00
 * <p/>
 * 描 述：网络解析使用
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class RepoHistory {

    /**
     * result : [{"_id":"11201101","title":"北宋江南方腊起义","pic":"http://juheimg.oss-cn-hangzhou
     * .aliyuncs.com/toh/201109/18/7D2278978.jpg","year":1120,"month":11,"day":1,
     * "des":"在897年前的今天，1120年11月1日 (农历十月初九)，北宋江南方腊起义。","lunar":"庚子年十月初九"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<HistoryBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<HistoryBean> getResult() {
        return result;
    }

    public void setResult(List<HistoryBean> result) {
        this.result = result;
    }


}
