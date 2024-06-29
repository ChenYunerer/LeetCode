package categorized.tree.leetcode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class Solution1 {

    /**
     * 二色迭代
     * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/thinkings/tree
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.node == null) {
                continue;
            }
            TreeNode node = pair.node;
            if (pair.flag == 1) {
                result.add(node.val);
            } else {
                stack.push(new Pair(node.right, 0));
                stack.push(new Pair(node, 1));
                stack.push(new Pair(node.left, 0));
            }
        }
        return result;
    }

    class Pair {
        TreeNode node;
        int flag;

        public Pair(TreeNode node, int flag) {
            this.node = node;
            this.flag = flag;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
