package leetcode_top_100.tree.lc108;

import basicalgorithm.tree.base.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(nums[endIndex]);
        }
        int middleIndex = (startIndex + endIndex) / 2;
        TreeNode treeNode = new TreeNode(nums[middleIndex]);
        treeNode.left = sortedArrayToBST(nums, startIndex, middleIndex - 1);
        treeNode.right = sortedArrayToBST(nums, middleIndex + 1, endIndex);
        return treeNode;
    }
}
