package leetcode.com;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class LeetCode_45_JumpGame2 {
    private int minJump = Integer.MAX_VALUE;
    private int[] memo;

    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);

        dfs(0, 0, nums);

        return minJump != Integer.MAX_VALUE ? minJump : Integer.MAX_VALUE;
    }

    public void dfs(int idx, int jump, int[] nums) {
        if (idx >= nums.length || jump >= memo[idx]) return;
        memo[idx] = jump;

        if (idx == nums.length - 1) {
            minJump = Math.min(jump, minJump);
            return;
        }

        for (int i = idx + 1; i <= idx + nums[idx]; i++) {
            dfs(i, jump + 1, nums);
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4}; // 0 -> 1 - > 4
        int minimumJump = new LeetCode_45_JumpGame2().jump(arr);

        Assertions.assertEquals(2, minimumJump);
    }


}
