package com.jusfoun.ssz.eureka.server;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-07-25 17:24
 **/
public class Sync {

    public int i;

    public void method1(String[] args) {

    }

    public synchronized void method2(String[] args) {

    }

    public void method3(String[] args) {
        synchronized (this){
            i ++;
        }
    }

    public static synchronized void method4(String[] args) {

    }
}
