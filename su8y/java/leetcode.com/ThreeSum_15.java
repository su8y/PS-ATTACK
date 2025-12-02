package leetcode.com;

import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {

        int[] nums = {-2, 0, 1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    /**
     * @return 중복이 있으면 안되기 때문에 set 자료로 받아 List<>로 바꿔서 리턴한다.
     * 이 방식은 O(n^2) 인데 더 좋은 방법이 있을거 같다.
     * @Solution 한번 정렬을 하고
     * @var i =  (0 > arrs.length)
     * @var l = i +1
     * @var r = arr.length-1;
     * @var sum = i + l + r
     * sum == 0 이면 list에 넣어주고
     * sum < 0 작다는 거기 때문에 l 을 올려준다.
     * sum > 0 이면 크다는 거기 때문에 r을 올려준다.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int[] arrs = nums.clone();
        Arrays.sort(arrs);

        int l, r;
        for (int i = 0; i < arrs.length - 2; i++) {
            int target = arrs[i];
            l = i + 1;
            r = arrs.length - 1;
            while (l < r) {
                int sum = arrs[l] + arrs[r];
                if (sum + target == 0) result.add(Arrays.asList(arrs[i], arrs[l], arrs[r]));
                if (sum + target < 0) {
                    l++;
                }
                if (sum + target >= 0) {
                    r--;
                }
            }

        }


        List<List<Integer>> res = new ArrayList<>(result);

        return res;
    }

}
