package categorized.recursion.swordtooffer33;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author yunyu.cy
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return doVerifyPostorder(postorder, postorder.length - 1 - 2, postorder.length - 1).isPostorder;
    }

    public Result doVerifyPostorder(int[] postorder, int start, int end) {


        Integer root = end < 0 ? null : postorder[end];
        Integer left = start < 0 ? null : postorder[start];
        Integer right = (start + 1) < 0 ? null : postorder[(start + 1)];

        Result result = new Result(true, null);
        if (start >= 0) {
            start = start - 2;
            end = end - 2;
            result = doVerifyPostorder(postorder, start, end);
        }
        boolean isPostorder = result.isPostorder && (left == null || left <= root) && (right == null || right >= root) && (result.maxVal == null || result.maxVal <= root);
        return new Result(isPostorder, right);
    }

    public class Result {
        boolean isPostorder;
        Integer maxVal;

        public Result(boolean isPostorder) {
            this.isPostorder = isPostorder;
        }

        public Result(boolean isPostorder, Integer maxVal) {
            this.isPostorder = isPostorder;
            this.maxVal = maxVal;
        }
    }
}
