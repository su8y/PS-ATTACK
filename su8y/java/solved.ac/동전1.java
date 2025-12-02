package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1 {
    static int N, K;

    static int[] arr = new int[101];
    //    static int dp[][];
    static int[] d1;
    static int[] d2;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        solve(0, 1);
//        System.out.println(count);
        // 메모리초과 코드 좋은 방법 1
//        dp = new int[N+1][K + 1];
//        for (int i = 0; i <= N; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K ; j++) {
//                //동전의 가치가 0보다 작아지지않는지
//                dp[i][j] = dp[i-1][j];
//                if(j >= arr[i]) dp[i][j] += dp[i][j - arr[i]];
//            }
//
//        }
//        System.out.println(dp[N][K]);
        /** 메모리 초과 해결 코드 */
        /*k 이하의 a[0]의 배수들에 대해 모두 경우의 수가 1이기때문에 초기화*/
        d1 = new int[K + 1];
        d2 = new int[K + 1];
        for (int i = 0; i <= K; i += arr[1]) {
            d1[i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            Arrays.fill(d2, 0);
            for (int j = 0; j <= K; j++) {
                d2[j] = d1[j];
                if (j >= arr[i]) d2[j] += d2[j - arr[i]];
            }
            d1 = d2.clone();
        }
        System.out.println(d1[K]);


    }

    private static void solve(int sum, int index) {
        if (sum > K || index >= N + 1) return;
        if (sum == K) {
            count++;
            return;
        }
        solve(sum + arr[index], index);
        solve(sum, index + 1);
    }
}