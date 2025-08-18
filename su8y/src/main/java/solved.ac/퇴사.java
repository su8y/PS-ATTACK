package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N, M;
    static int[] dp, T, P;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 2]; // 마지막 하루 10일이면 11일날에 최대값을 구함
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N + 1; i++) {
            if (i + T[i] < N + 2)
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        bw.write(String.valueOf(dp[N + 1]));
        bw.flush();
        bw.close();
        br.close();
    }
}