package com.chenly.model;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @author wangchuan
 * @date 2019/11/19.
 */
public class MyCallable implements Callable {
    private String ss;

    public MyCallable(String args){
        ss = args;
    }

    @Override
    public Object call() throws Exception {
        return "我是"+ ss + "号憨憨";
    }
}
