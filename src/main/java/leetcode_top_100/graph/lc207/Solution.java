package leetcode_top_100.graph.lc207;


/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] finishedList = new boolean[numCourses];
        int[] preconditionNum = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisit = prerequisites[i];
            preconditionNum[prerequisit[0]]++;
        }
        int allFinishNum = 0;
        while (true) {
            int curRoundNum = 0;
            for (int i = 0; i < preconditionNum.length; i++) {
                if (!finishedList[i] && preconditionNum[i] == 0) {
                    finishedList[i]= true;
                    curRoundNum++;
                    for (int j = 0; j < prerequisites.length; j++) {
                        int[] prerequisit = prerequisites[j];
                        if (prerequisit[1] == i) {
                            preconditionNum[prerequisit[0]]--;
                        }
                    }
                }
            }
            if (curRoundNum == 0) {
                break;
            } else {
                allFinishNum = allFinishNum + curRoundNum;
            }
        }
        return allFinishNum == numCourses;
    }

    public static void main(String[] args) {
        new Solution().canFinish(2, new int[][]{{1, 0}});
    }
}
