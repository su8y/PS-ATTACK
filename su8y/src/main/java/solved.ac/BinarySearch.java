package solved.ac;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearch {
    public static void main(String[] args) {
        int lefta = 0;
        String str = "str";
        String s = str + lefta;
        System.out.println(s);

    }

    public int search(int[] nums, int target) {
        int lefta = 0;

        int riiiiight = nums.length - 1;

        Queue<Integer> q = new LinkedList<>();

        while (lefta <= riiiiight) {
            int pivot = (lefta + riiiiight) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                lefta = pivot + 1;
            } else if (nums[pivot] > target) {
                riiiiight = pivot - 1;
            }
        }
        return -1;
    }
}