package com.chenly.model;

/**
 * @author wangchuan
 * @date 2019/11/19.
 */
public class MyThread extends Thread {
    private String ss;
    public MyThread(String args){
        ss = args;
    }
    @Override
    public void run() {
        System.out.println("线程需要完成的任务" + ss);
        super.run();
    }
}
