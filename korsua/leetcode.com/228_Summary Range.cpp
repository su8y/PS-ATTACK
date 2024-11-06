/*
228. Summary Ranges
https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> ret;
        if(nums.size() == 0) return ret;
        if(nums.size() == 1) {
            ret.push_back(to_string(nums[0]));
            return ret;
        }
        int l = 0; int r = 1;
        while(r != nums.size()){
            int ln = nums[l];
            int rn = nums[r];
            if(ln + (r-l) == rn) r++;
            else {
                if(r-l == 1){
                    ret.push_back(to_string(ln));
                }else{
                    string s = to_string(ln)+"->"+to_string(nums[r-1]);
                    ret.push_back(s);
                }
                l = r;
                r = l + 1;
            }
        }
        if(l == nums.size() -1){
            ret.push_back(to_string(nums[l]));
        }else {
            string s = to_string(nums[l])+"->"+to_string(nums[r-1]);
            ret.push_back(s);
        }
        return ret;
    }
};