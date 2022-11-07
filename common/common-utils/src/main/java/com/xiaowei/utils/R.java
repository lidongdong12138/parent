package com.xiaowei.utils;

import lombok.Data;

@Data
public class R<T> {

    private R() {}

    private Boolean success;

    private Integer code;

    private String msg;

    private T data;

    public static R ok()
    {
        R r = new R<>();
        r.setSuccess(true);
        r.setMsg("成功");
        r.setCode(ResultCode.SUCCESS);
        return r;
    }

    public static R fail()
    {
        R r = new R<>();
        r.setSuccess(false);
        r.setMsg("失败");
        r.setCode(ResultCode.FAIL);
        return r;
    }

    public R code(Integer code)
    {
        this.code = code;
        return this;
    }

    public R msg(String msg)
    {
        this.msg = msg;
        return this;
    }
    public R<T> data(T data)
    {
        this.data = data;
        return this;
    }

}
