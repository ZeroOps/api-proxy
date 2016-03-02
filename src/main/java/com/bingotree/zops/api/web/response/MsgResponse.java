package com.bingotree.zops.api.web.response;

/**
 * Created by thuanqin on 16/3/2.
 */
public class MsgResponse {

    private String msg;

    public MsgResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
