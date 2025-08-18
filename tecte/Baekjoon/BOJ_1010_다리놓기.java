/*
 * 문제: 백준 1010번 - 다리 놓기 (https://www.acmicpc.net/problem/1010)
 * 문제 풀이
 *  DP로 조합 계산을 함. 점화식은 C(m, n) = C(m-1, n-1) + C(m-1, n)
 *  C(m-1, n-1): m-1개의 원소에서 n-1개를 선택한 경우 (m번째 사이트를 선택한 경우).
 *  C(m-1, n): m-1개의 원소에서 n개를 선택한 경우 (m번째 사이트를 선택하지 않는 경우).
 *
 * 시간 복잡도: O(t * n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] memo = new int[n + 1][m + 1];

            for (int i = 0; i <= m; i++) {
                memo[0][i] = 1;
            }

            for (int i = 1; i <= n; i++) {
                memo[i][i] = 1;

                for (int j = i + 1; j <= m; j++) {
                    memo[i][j] = memo[i][j - 1] + memo[i - 1][j - 1];
                }
            }

            bw.write(memo[n][m] + "\n");
        }

        br.close();
        bw.close();
    }
}
