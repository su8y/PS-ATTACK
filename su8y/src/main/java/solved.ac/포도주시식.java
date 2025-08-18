package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.lang.Math.max;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[10001];
        int[] dp = new int[10001];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = max(
                    dp[i - 2] + arr[i],
                    dp[i - 3] + arr[i - 1] + arr[i]
            );
            dp[i] = max(dp[i - 1], dp[i]);
        }
        PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());
        for (int i : dp) {
            queue.add(i);
        }
        System.out.println(queue.peek());

    }
}
