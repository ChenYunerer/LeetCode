package categorized.tree.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeUtil {


    public static TreeNode genTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Deque<Integer> valDeque = new LinkedList<>();
        for (Integer integer : array) {
            valDeque.offer(integer);
        }
        Integer firstVal = valDeque.poll();
        TreeNode root = firstVal == null ? null : new TreeNode(firstVal);

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()) {
            TreeNode treeNode = treeNodeDeque.poll();
            if (treeNode == null) {
                continue;
            }
            Integer leftVal = valDeque.poll();
            TreeNode leftTreeNode = leftVal == null ? null : new TreeNode(leftVal);
            treeNode.left = leftTreeNode;
            treeNodeDeque.offer(leftTreeNode);

            Integer rightVal = valDeque.poll();
            TreeNode rightTreeNode = rightVal == null ? null : new TreeNode(rightVal);
            treeNode.right = rightTreeNode;
            treeNodeDeque.offer(rightTreeNode);
        }
        return root;
    }

    public static TreeNode searchByVal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftRes = searchByVal(root.left, val);
        if (leftRes != null) {
            return leftRes;
        }
        TreeNode rightRes = searchByVal(root.right, val);
        return rightRes;
    }


    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<List<Integer>> allLevelList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelCount = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode treeNode = deque.poll();
                level.add(treeNode == null ? null : treeNode.val);
                if (treeNode != null) {
                    deque.offer(treeNode.left);
                    deque.offer(treeNode.right);
                }
            }
            allLevelList.add(level);
        }
        for (List<Integer> level : allLevelList) {
            for (Integer val : level) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = genTreeNode(new Integer[]{1, 2, 3, null, null, 6, 7});
        printTreeNode(treeNode);
    }

}
