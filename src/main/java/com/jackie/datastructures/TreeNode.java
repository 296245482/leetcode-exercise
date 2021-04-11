package com.jackie.datastructures;

import lombok.Data;

/**
 * LeetCode-树结构
 *
 * @author Long Cheng
 * @date 2021/3/13.
 */
@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
