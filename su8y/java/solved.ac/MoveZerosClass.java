package solved.ac;

import java.util.Arrays;

public class MoveZerosClass {
    /*
     * [ 0 , 5 , 0 , 7 , 6 , 3 ] = > [ 5 , 7, 6 , 3 , 0 , 0]
     * two pointer 전략 0과 0이아닌 숫자를 스와핑 해줌 .
     * */
    public static void moveZeros(int[] nums) {
        int wIdx = 0; // 0을 가르킴.
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                nums[wIdx] = nums[idx];
//                 nums[wIdx] = mySwap(nums[idx], nums[idx] = nums[wIdx]);
                wIdx++;
            }
        }

        Arrays.fill(nums, wIdx, nums.length, 0);
//        for(; wIdx < nums.length; wIdx++){
//            nums[wIdx] = 0;
//        }

    }

    private static int mySwap(int localA, int localB) {
        return localA;
    }
}
