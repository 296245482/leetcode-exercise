package com.jackie.medium;

import com.jackie.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < nodeQueue.size(); i++) {

                TreeNode node = nodeQueue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
