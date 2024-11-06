class Solution {
public:
    /*
    https://leetcode.com/problems/container-with-most-water
    양 끝 포인트 에서 둘 중에 더 작은 포인트를 중심 점으로 이동하면서 가장 큰 크기를 계산한다.
    */
    int maxArea(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int ret = 0;
        while (l < r) {
            int w = r - l;
            int h = min(height[l], height[r]);
            ret = max(ret, w * h);
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return ret;
    }
};
