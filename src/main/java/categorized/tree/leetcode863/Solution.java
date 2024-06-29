package categorized.tree.leetcode863;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Solution {
    Map<TreeNode, TreeNode> nodeAndParentMap = new HashMap<>();
    int k;
    List<Integer> ans = new ArrayList<>();
    List<TreeNode> ready = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeUtil.genTreeNode(new Integer[]{0, 1, null, 3, 2});
        TreeNode target = TreeUtil.searchByVal(root, 2);
        Solution solution = new Solution();

        List<Integer> ans = solution.distanceK(root, target, 1);
        System.out.println(ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;

        dfsForBuildMap(root);

        dfs(target, 0);

        while (nodeAndParentMap.get(target) != null) {
            this.k--;
            if (this.k < 0) {
                break;
            }
            TreeNode node = nodeAndParentMap.get(target);
            dfs(node, 0);
            target = node;
        }
        return ans;
    }

    private void dfsForBuildMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            nodeAndParentMap.put(root.left, root);
            dfsForBuildMap(root.left);
        }
        if (root.right != null) {
            nodeAndParentMap.put(root.right, root);
            dfsForBuildMap(root.right);
        }
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (ready.contains(root)) {
            return;
        }
        ready.add(root);
        if (deep == k) {
            ans.add(root.val);
            return;
        }
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }


}
