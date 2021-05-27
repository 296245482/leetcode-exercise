package com.jackie.medium;

import com.jackie.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/4.
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            List<Integer> insideQueue = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode curr = queue.poll();
                if (isOrderLeft) {
                    insideQueue.add(curr.val);
                } else {
                    insideQueue.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(insideQueue);
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }
}
//develop1 commit2
//develop2 commit2
//develop1 commit2
