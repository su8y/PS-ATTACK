package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 가장_긴_증가하는_부분_수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[1001];
        int[] arr = new int[1001];
        String[] s = reader.readLine().split(" ", n);
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(s[i]);
        }
        dp[1] = 1; // dp 1은 무조건 1
        for (int i = 2; i <= n; i++) {
            int val = 0;
            for (int j = 1; j < i; j++) {
                // 2... val 업데이트 작은 값을 찾는다 . lower 바운드랑 같은 원ㄹ ㅣ
                if (arr[j] < arr[i]) {
                    if (val < dp[j]) { // 업데이트된 dp의 개수보다 작냐 .
                        val = dp[j];
                    }
                }
                // 1..
                dp[i] = val + 1;
            }
        }
        Stack<Integer> v = new Stack<Integer>();
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
//        System.out.println("dp");
//        for (int i = 0; i <= n; i++) {
//            System.out.print(" " + dp[i]);
//        }
//        System.out.println("arr");
//        for (int i = 0; i <= n; i++) {
//            System.out.print(" " + arr[i]);
//        }
        for (int i = n; i > 0; i--) {
            if (dp[i] == max) {
                v.add(arr[i]);
                --max;
            }
        }
        int size = v.size();
        for (int i = 0; i < size; i++) {
            System.out.print(v.pop() + " ");
        }

        // o(n^2) 풀었다.
        // o(n log n) 으로 줄일수 있는 방법
        // binary 서치를 통한 val 갱신 속도 개선
    }
}
