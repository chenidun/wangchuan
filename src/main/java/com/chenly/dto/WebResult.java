package com.chenly.dto;

import lombok.Data;

/**
 * @author wangchuan
 * @date 2019/11/8.
 */
@Data
public class WebResult<T> {
    private int code;
    private String message;
    private T data;

    public static <T> WebResult<T> build(){ return null;}

}
