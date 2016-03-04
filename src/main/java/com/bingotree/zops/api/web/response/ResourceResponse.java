package com.bingotree.zops.api.web.response;

import java.util.List;

/**
 * Created by thuanqin on 16/3/2.
 */
public class ResourceResponse {

    private int result; //0:请求正常完成 其它:请求出错
    private int id; //申请到资源的id
    private List<Integer> ids; //申请到资源的id列表

    public ResourceResponse() {
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
