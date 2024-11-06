class Solution {
/*
https://leetcode.com/problems/remove-element/
50의 값들이 총 100개 들어올 수 있으니 최대 값은 5000이다. 
시간복잡도는 O(NlogN)
*/
public:
    int removeElement(vector<int>& nums, int val) {
        for (auto& num : nums) {
            if (num == val) {
                num = 9999;
            }
        }
        sort(nums.begin(), nums.end());
        int i = 0;
        while (i < nums.size() && nums[i] != 9999) {
            i++;
        }
        return i;
    }
};
