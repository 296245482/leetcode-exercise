package com.designpattern.singleton;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/5.
 */
public enum EnumSingleton {
    INSTANCE;


    public static EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}

/**
 * 简单、但是可读性差，日常很少使用
 */