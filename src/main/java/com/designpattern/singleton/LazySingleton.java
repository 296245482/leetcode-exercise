package com.designpattern.singleton;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/3.
 */
public class LazySingleton {


    private static LazySingleton lazySingleton;

    private LazySingleton() {

    }

    public static LazySingleton getLazySingleton() {
        // 只有真正使用时才去创建单例；但是如果多个线程同时进入了下面的if语句，则会导致多个实例被创建
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
