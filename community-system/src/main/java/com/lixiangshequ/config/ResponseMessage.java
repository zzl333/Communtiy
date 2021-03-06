package com.lixiangshequ.config;

public class ResponseMessage<T> {
    private boolean success;
    private String msg;
    private T data;
    private String url;

    public ResponseMessage() {
    }

    public ResponseMessage(boolean success, String msg, T data, String url) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.url = url;
    }

    public ResponseMessage(String msg, T data) {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
