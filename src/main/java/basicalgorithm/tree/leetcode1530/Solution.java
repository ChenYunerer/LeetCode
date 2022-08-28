package basicalgorithm.tree.leetcode1530;

import basicalgorithm.tree.base.TreeNode;
import basicalgorithm.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 1530. 好叶子节点对的数量
 * https://leetcode.cn/problems/number-of-good-leaf-nodes-pairs/
 */
public class Solution {

    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{1, 2, 3, null, 4});
        Solution solution = new Solution();
        int result = solution.countPairs(root, 3);
        System.out.println(result);
    }

    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }
        dfs(root, distance);
        return ans;
    }

    public List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            List<Integer> result = new ArrayList<>();
            return result;
        }
        if (root.left == null && root.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<Integer> leftResult = dfs(root.left, distance);
        for (int i = 0; i < leftResult.size(); i++) {
            Integer item = leftResult.get(i);
            item = item + 1;
            leftResult.set(i, item);
            if (item > distance) {
                leftResult.remove(i);
                i--;
            }
        }
        List<Integer> rightResult = dfs(root.right, distance);
        for (int i = 0; i < rightResult.size(); i++) {
            Integer item = rightResult.get(i);
            item = item + 1;
            rightResult.set(i, item);
            if (item > distance) {
                rightResult.remove(i);
                i--;
            }
        }
        for (int i = 0; i < leftResult.size(); i++) {
            for (int j = 0; j < rightResult.size(); j++) {
                if (leftResult.get(i) + rightResult.get(j) <= distance) {
                    ans++;
                }
            }
        }
        leftResult.addAll(rightResult);
        return leftResult;
    }
}
