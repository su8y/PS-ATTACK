/*
 * 문제: 백준 2758번 - 로또 (https://www.acmicpc.net/problem/2758)
 * 문제 풀이
 * 	2차원 배열 dp[n+1][m+1]을 선언, dp[x][y]은 로또의 x번째 자리에 y이상의 수가 올 수 있는 경우의 수.
 * 	예를 들어, n=2, m=4일 때
 * 	dp[1][1]에는 1번째 자리에 1이상의 수인 1,2,3,4 중에 1,2만 올 수 있음.
 * 	1,2는 두번째 자리에 올 수 있는 수가 범위가 넘어가지 않지만 3,4는 두번째 자리에 올 수 있는 수가 범위를 넘어감.
 * 	첫번째 자리가 1인 경우 두번째 자리에는 2,3,4 3개가 올수 있고 첫번째 자리가 2인 경우 두번째 자리에는 4 1개만 올 수 있어.
 * 	dp[1][1]에는 3+1인 4가 저장 됨 즉, dp[x][y] = dp[x+1][y*2] + dp[x][y+1]로 정의할 수 있음.
 * 	이를 재귀 호출하면 dp[1][1]에는 구매할 수 있는 로또의 최대 개수가 저장됨.
 *
 * 시간 복잡도: O(t * n * m)
 */

package baekjoon.workbook0.chapter2.section7;

import java.io.*;

public class BOJ_2758_로또 {
    // public class Main {
    private static int n, m;
    private static long dp[][];

    private static long lotto(int x, int y) {
        if (dp[x][y] == 0) {
            if (x == n)
                dp[x][y] = m - y + 1;
            else if (y << (n - x) <= m)
                dp[x][y] = lotto(x + 1, y * 2) + lotto(x, y + 1);
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String input[] = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            dp = new long[n + 1][m + 1];

            bw.write(lotto(1, 1) + "\n");
        }

        br.close();
        bw.close();
    }
}
