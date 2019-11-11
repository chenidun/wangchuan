package com.chenly.dto;

import com.chenly.constand.WebCodeEnum;
/**
 * @author wangchuan
 * @date 2019/11/8.
 */
public class WebResult<T> {
    private int code;
    private String message;
    private T data;

    public static <T> WebResult<T> build(WebCodeEnum resultCode, T data){
        WebResult<T> baseResult = new WebResult<>();
        baseResult.setCode(resultCode.getCode());
        baseResult.setMessage(resultCode.getMessage());
        baseResult.setData(data);
        return baseResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
