package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장_긴_증가하는_부분수열2 {
    public static int lower_bound(List<Integer> dp, int target) {
        int begin = 0;
        int end = dp.size();

        while (begin < end) {
            int mid = (begin + end) / 2;
            if (dp.get(mid) >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> dp = new ArrayList<>();
        int[] arr = new int[1001];
        String[] s = reader.readLine().split(" ", n);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] copyarr = Arrays.copyOfRange(arr, 0, n);
        dp.add(arr[0]);
        int index;
        // dp 1은 무조건 1
        for (int i = 0; i < n; i++) {
            if ((index = lower_bound(dp, arr[i])) == dp.size()) {
                dp.add(arr[i]);
                arr[i] = index + 1;
            } else {
                dp.set(index, arr[i]);
                arr[i] = index + 1;
            }
        }

//        for(int i = 0 ; i<n ; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0 ; i<n ; i++){
//            System.out.print(copyarr[i] + " ");
//        }
//        System.out.println();
        System.out.println(dp.size());
//        int max = dp.size();
//        Stack<Integer> ss = new Stack<>();
//        for(int i = n -1 ; i >=0; i--){
//            if (max == arr[i]) {
//                ss.push(copyarr[i]);
//                --max;
//            }
//        }
//        for(int i = 0 ,len = ss.size(); i< len; i++){
//            System.out.print(ss.pop()+ " ");
//        }


        // o(n^2) 풀었다.
        // o(n log n) 으로 줄일수 있는 방법
        // binary 서치를 통한 val 갱신 속도 개선
    }
}
