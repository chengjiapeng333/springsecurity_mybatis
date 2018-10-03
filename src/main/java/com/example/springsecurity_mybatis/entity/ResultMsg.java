package com.example.springsecurity_mybatis.entity;

public class ResultMsg {
    private int status;  //1成功，0失败

    private String msg;

    private String data;

    public ResultMsg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultMsg(int status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
