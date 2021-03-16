package com.lixiangshequ.config;

public class ResposeMessage<T> {
    private String msg;
    private T data;
    private String url;

    public ResposeMessage() {
    }

    public ResposeMessage(String msg, T data, String url) {
        this.msg = msg;
        this.data = data;
        this.url = url;
    }

    public ResposeMessage(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
