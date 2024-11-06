/*
70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
public:
    int climbStairs(int n) {
        int dp[46]= {0,};
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<46;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};