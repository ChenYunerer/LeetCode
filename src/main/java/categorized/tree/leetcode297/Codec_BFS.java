package categorized.tree.leetcode297;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec_BFS {

    // BFS思路
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuffer resultSB = new StringBuffer();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                resultSB.append("null");
                resultSB.append(",");
            } else {
                resultSB.append(treeNode.val);
                resultSB.append(",");
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
        }
        return resultSB.substring(0, resultSB.length() - 1);
    }

    // BFS思路
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] array = data.split(",");
        if (array.length == 0) {
            return null;
        }
        Deque<Integer> integerDeque = new LinkedList<>();
        for (String str : array) {
            integerDeque.offer(str.equals("null") ? null : Integer.parseInt(str));
        }
        Integer firstVal = integerDeque.poll();
        TreeNode root = new TreeNode(firstVal);
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            TreeNode node = nodeDeque.poll();
            Integer leftVal = integerDeque.poll();
            if (leftVal != null) {
                TreeNode leftNode = new TreeNode(leftVal);
                node.left = leftNode;
                nodeDeque.offer(leftNode);
            }
            Integer rightVal = integerDeque.poll();
            if (rightVal != null) {
                TreeNode rightNode = new TreeNode(rightVal);
                node.right = rightNode;
                nodeDeque.offer(rightNode);
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
