package basicalgorithm.recursion.leetcode654;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }

    /**
     * 分治思路
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode treeNode = doConstructMaximumBinaryTree(nums, 0, nums.length - 1);
        return treeNode;
    }

    public TreeNode doConstructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end || start >= nums.length || end >= nums.length) {
            return null;
        }
        int length = end - start + 1;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(nums[start]);
        }
        int maxNumIndex = start;
        int maxNum = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxNumIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = maxNum;
        root.left = doConstructMaximumBinaryTree(nums, start, maxNumIndex - 1);
        root.right = doConstructMaximumBinaryTree(nums, maxNumIndex + 1, end);
        return root;
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

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
