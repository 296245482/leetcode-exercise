package com.designpattern.Singleton;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/3.
 */
public class HungrySingleton {

    // 类装载时即完成了实例化，避免了线程同步问题；但是如果这个单例一直没有被用到就会导致
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
