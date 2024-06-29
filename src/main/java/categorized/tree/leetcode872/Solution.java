package categorized.tree.leetcode872;

import categorized.tree.base.TreeNode;
import categorized.tree.base.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * https://leetcode.cn/problems/leaf-similar-trees/
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.genTreeNode(new Integer[]{1, 2});
        TreeNode root2 = TreeUtil.genTreeNode(new Integer[]{2, 2});
        Solution solution = new Solution();
        boolean result = solution.leafSimilar(root1, root2);
        System.out.println(result);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1LeafList = new ArrayList<>();
        def(root1, root1LeafList);

        List<Integer> root2LeafList = new ArrayList<>();
        def(root2, root2LeafList);
        return root1LeafList.equals(root2LeafList);
    }

    public void def(TreeNode root, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        def(root.left, leaf);
        def(root.right, leaf);
    }
}
