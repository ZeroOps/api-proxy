package com.bingotree.zops.api.web.response;

/**
 * Created by thuanqin on 16/3/4.
 */
public class MachineResponse {

    private int result; //0:请求正常完成 其它:请求出错
    private int id; // 新增主机后的主机id

    public MachineResponse() {
    }

    public int getResult() {
        return result;
    }

    public MachineResponse setResult(int result) {
        this.result = result;
        return this;
    }

    public int getId() {
        return id;
    }

    public MachineResponse setId(int id) {
        this.id = id;
        return this;
    }
}
