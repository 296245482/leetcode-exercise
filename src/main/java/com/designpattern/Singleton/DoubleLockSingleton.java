package com.designpattern.Singleton;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/5.
 */
public class DoubleLockSingleton {
    private volatile static DoubleLockSingleton doubleLockSingleton;

    private DoubleLockSingleton(){}


    // 双重检查模式，进行了两次判断
    public static DoubleLockSingleton getInstance(){
        if (doubleLockSingleton == null) {
            synchronized(DoubleLockSingleton.class) {
                if (doubleLockSingleton == null) {
                    doubleLockSingleton = new DoubleLockSingleton();
                }
            }
        }
        return doubleLockSingleton;
    }
}
