package solved.ac;

public class MergeSortClass {
    /**
     * @param nums1 [1,2,3,0,0,0]
     * @param n     3
     * @param nums2 [4,5,6]
     * @param m     3
     * @return [1, 2, 3, 4, 5, 6]
     */
    public static void mergeSorted(int[] nums1, int n, int[] nums2, int m) {
        int num1Idx = n - 1;
        int num2Idx = m - 1;
        int wIdx = nums2.length - 1;

        if (num2Idx < 0) return;
        while (0 <= num1Idx && 0 <= num2Idx) {
            int num1 = nums1[num1Idx];
            int num2 = nums2[num2Idx];
            if (num1 <= num2) {
                int num = num2;
                nums1[wIdx] = num;
                num2Idx--;
                wIdx--;
            } else {
                int num = num1;
                nums1[wIdx] = num;
                num1Idx--;
                wIdx--;
                nums1[wIdx] = nums1[num1Idx];
                num1Idx--;
                wIdx--;
            }


        }
    }
}

