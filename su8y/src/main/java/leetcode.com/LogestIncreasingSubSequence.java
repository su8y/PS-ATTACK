package leetcode.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogestIncreasingSubSequence {
    static int[] cache = new int[10];
    static int[] arr = {9, 8, 7, 1, 2, 3, 5, 10, 1};

    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int result = lis(list);
        System.out.println(result);
        /**
         * lis2를 호출할때는 항상 증가 부분 수열의 시작위치를 지정해줘야 되므로, 처음에 호출할 때 각 위치를 순회하면서 최대 값을 찾는 밑에 형태의 코드를 만들어줘야한다.
         * */
        int maxLen = 0;
        for (int begin = 0; begin < 8; begin++) {
            maxLen = Math.max(maxLen, lis2(begin));
        }
        System.out.println(maxLen);
        /**
         * 1을 빼줘야 함 cache[]에 접근할때 cache[start] 대신 cache[start + 1] 을 쓰는것을 유의해보자
         * cache[]의 크기도 1 커졌다. 이제 lis3(-1) -1 을 결과를 써야한다.
         */
        System.out.println(lis3(-1) - 1);
        System.out.println(LIS(arr));
    }

    //broute force
    private static int lis(List<Integer> arr) {
        if (arr.isEmpty()) return 0;
        int ret = 1;

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) {
                    list.add(arr.get(j));
                }
                ret = Math.max(ret, 1 + lis(list));

            }
        }
        return ret;
    }

    private static int lis2(int start) {
        if (cache[start] == -1) return cache[start];
        cache[start] = 1;
        for (int next = start + 1; next < 8; next++) {
            if (arr[start] < arr[next]) {
                cache[start] = Math.max(cache[start], lis2(next) + 1);

            }
        }
        return cache[start];
    }

    private static int lis3(int start) {
        if (cache[start + 1] == -1) return cache[start + 1];
        cache[start + 1] = 1;
        for (int next = start + 1; next < 8; next++) {
            if (start == -1 || arr[start] < arr[next]) {
                cache[start + 1] = Math.max(cache[start + 1], lis3(next) + 1);
            }
        }
        return cache[start + 1];
    }

    private static int LIS(int[] arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(arr[0]);
        int max = 0;
        int index;
        for (int i = 0; i < arr.length; i++) {
            if (
                    (index = lower_bound(dp, arr[i])) == dp.size()
            ) {
                dp.add(arr[i]);
            } else {
                dp.set(index, arr[i]);
            }
//            arr[i] = index + 1;
            max = Math.max(max, index + 1);
        }


        return max;
    }

    static int lower_bound(List<Integer> dp, int target) {
        int begin = 0;
        int end = dp.size();

        while (begin < end) {
            int mid = (begin + end) / 2;
            if (dp.get(mid) >= target) end = mid;
            else begin = mid + 1;
        }

        return end;
    }
}
