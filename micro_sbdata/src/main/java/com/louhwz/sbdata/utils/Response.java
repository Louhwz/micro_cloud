package com.louhwz.sbdata.utils;

/**
 * @author Louhwz
 */
public class Response {
    // 状态码
    private int code;

    // 返回信息
    private String msg;

    // 返回数据
    // 有两种实现方法，一种是使用Object类，我看两个case里都是使用的这种
    // 还有一种是我觉得可以把数据库中的每个属性都设置一个变量
    private Sbdata data;

    public Response(int code, String msg, Sbdata data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Sbdata getData() {
        return data;
    }

    public void setData(Sbdata data) {
        this.data = data;
    }

}
