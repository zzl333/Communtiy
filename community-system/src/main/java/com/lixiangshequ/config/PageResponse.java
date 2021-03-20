package com.lixiangshequ.config;

import java.util.List;

/**
 * 分页包装数据据格式
 * {
 * "code": 0,
 * "msg": "",
 * "count": 1000,
 * "data": [{}, {}]
 * }
 */
public class PageResponse<T> {
    private Integer code;   //0成功  1不成功
    private String msg;
    private Integer count;
    private List<T> data;

    public PageResponse() {
    }

    public PageResponse(Integer code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
