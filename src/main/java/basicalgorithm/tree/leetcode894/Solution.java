package basicalgorithm.tree.leetcode894;

import basicalgorithm.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的真二叉树
 * https://leetcode.cn/problems/all-possible-full-binary-trees/
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> result = solution.allPossibleFBT(7);
        System.out.println(result.size());
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            result.add(root);
            return result;
        }
        for (int i = 1; i < n; i = i + 2) {
            List<TreeNode> leftResult = allPossibleFBT(i);
            List<TreeNode> rightResult = allPossibleFBT(n - i - 1);
            for (TreeNode leftNode : leftResult) {
                for (TreeNode rightNode : rightResult) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
