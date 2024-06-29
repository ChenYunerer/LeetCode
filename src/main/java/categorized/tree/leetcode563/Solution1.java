package categorized.tree.leetcode563;

import categorized.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 563. 二叉树的坡度
 * https://leetcode.cn/problems/binary-tree-tilt/description/
 */
public class Solution1 {

    private final Map<TreeNode, Integer> treeNodeSumMap = new HashMap<>();

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(dfsSum(root.left) - dfsSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int dfsSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum;
        if (treeNodeSumMap.containsKey(root.left)) {
            leftSum = treeNodeSumMap.get(root.left);
        } else {
            leftSum = dfsSum(root.left);
            treeNodeSumMap.put(root.left, leftSum);
        }
        int rightSum;
        if (treeNodeSumMap.containsKey(root.right)) {
            rightSum = treeNodeSumMap.get(root.right);
        } else {
            rightSum = dfsSum(root.right);
            treeNodeSumMap.put(root.right, rightSum);
        }
        return root.val + leftSum + rightSum;
    }
}
