package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一个数组可以用来表示一颗二叉树
 * 对于下标为n的元素，下标2n+1的元素对应它的左子节点的值，2n+2对应右子节点。
 * 给定一颗二叉树的根节点，将这颗二叉树的值输出到满足上面要求的数组中
 */
public class ByteDance1 {

    public static void solution1(String[] args) {
        Node root = null;
        List<Node> list = new ArrayList();
        list.add(root);
        int i = 0;
        while (true) {
            //这个结束条件不对，暂时找不到结束条件　
            if (i > list.size() - 1) {
                break;
            }
            if (list.get(i) == null) {
                list.add(2 * i + 1, null);
                list.add(2 * i + 2, null);
            } else {
                Node leftNode = list.get(i).left;
                //leftNode may be null
                list.add(2 * i + 1, leftNode);
                Node rightNode = list.get(i).right;
                //rightNode may be null
                list.add(2 * i + 2, rightNode);
            }
            i++;
        }
        //list to array 如果node节点是null则0，否则取value
    }

    public static List<List<Integer>> solution2() {
        Node root = null;
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            if (size == 0) {
                return list;
            }
            int shouldBreak = 1;
            for (int i = 0; i < size; i++) {
                Node t = queue.poll();
                list1.add(t == null ? 0 : t.value);
                queue.add(t == null ? null : t.left);
                queue.add(t == null ? null : t.right);
                if (t != null) {
                    shouldBreak = 0;
                }
            }
            list.add(list1);
            if (shouldBreak == 1) {
                return list;
            }
        }
    }

    /**
     * solution3(root, 0, list)
     */
    public static void solution3(Node root, int index, List<Integer> list) {
        list.add(index, root == null ? 0 : root.value);
        if (root != null) {
            solution3(root.left, 2 * index + 1, list);
            solution3(root.right, 2 * index + 2, list);
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;
    }
}
