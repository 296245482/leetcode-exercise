package com.designpattern.Singleton;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/5.
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return Inner.instance;
    }

    // 只有第一次调用getInstance方法时，虚拟机才加载并初始化instance
    private static class Inner {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }
}


/**
 * 最推荐的方法，既保证线程安全又保证唯一。
 */