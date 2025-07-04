/*
 * 문제: 백준 2169번 - 로봇 조종하기 (https://www.acmicpc.net/problem/2169)
 * 문제 풀이
 *  각 칸에 이동할 수 있는 경로는 위에서 오는 경우, 왼쪽에서 오는 경우, 오른쪽에서 오는 경우가 있음.
 *  이 세 경로 중에서 가장 큰 값으로 메모이제이션 함.
 *  이미 탐사한 지역은 다시 이동할 수 없으므로 오른쪽 이동과 왼쪽 이동을 분리해서 계산.
 *  왼쪽에서 오른쪽으로 이동하며 위에서 오는 경우와 비교하며 dp 값 갱신.
 *  오른쪽에서 왼쪽으로 이동하며 위에서 오는 경우와 비교하며 dp 값 갱신.
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2169_로봇조종하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] mars = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++)
            mars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp[0][0] = mars[0][0];

        for (int i = 1; i < m; i++)
            dp[0][i] = dp[0][i - 1] + mars[0][i];

        for (int i = 1; i < n; i++) {
            int[] arr = new int[m];

            for (int j = 0; j < m; j++)
                dp[i][j] = arr[j] = dp[i - 1][j] + mars[i][j];

            for (int j = 1; j < m; j++)
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + mars[i][j]);

            for (int j = m - 2; j >= 0; j--) {
                arr[j] = Math.max(arr[j], arr[j + 1] + mars[i][j]);
                dp[i][j] = Math.max(dp[i][j], arr[j]);
            }
        }

        bw.write(Integer.toString(dp[n - 1][m - 1]));
        br.close();
        bw.close();
    }
}
