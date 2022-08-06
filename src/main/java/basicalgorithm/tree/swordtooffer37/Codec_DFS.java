package basicalgorithm.tree.swordtooffer37;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec_DFS {


    // DFS思路
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        doSerialize(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void doSerialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }

    // DFS思路
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
        if (firstVal == null) {
            return null;
        }
        TreeNode root = new TreeNode(firstVal);
        doDeserialize(root, integerDeque);
        return root;
    }

    public void doDeserialize(TreeNode root, Deque<Integer> integerDeque) {
        if (root == null) {
            return;
        }
        Integer leftVal = integerDeque.poll();
        TreeNode leftNode = leftVal == null ? null : new TreeNode(leftVal);
        root.left = leftNode;
        doDeserialize(leftNode, integerDeque);

        Integer rightVal = integerDeque.poll();
        TreeNode rightNode = rightVal == null ? null : new TreeNode(rightVal);
        root.right = rightNode;
        doDeserialize(rightNode, integerDeque);
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
