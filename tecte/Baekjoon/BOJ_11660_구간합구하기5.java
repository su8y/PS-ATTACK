/*
 * 문제 : 백준 11660번 - 구간 합 구하기 5 (https://www.acmicpc.net/problem/11660)
 *  dp로 구간의 합을 구함
 *  (x, y)까지의 구간 합은 (x-1, y)까지의 구간 합 + (x, y-1)까지의 구간 합 - dp(x-1, y-1)까지의 구간 합 + (x, y)의 값
 *  (x1, y1)에서 (x2, y2)의 구간 합은 (x2, y2)까지의 구간 합 - (x2, y1-1)까지의 구간 합 - (x1-1, y2)까지의 구간 합 + (x1-1, y1-1)까지의 구간 합
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(arr[x2][y2] - arr[x2][y1] - arr[x1][y2] + arr[x1][y1] + "\n");
        }

        br.close();
        bw.close();
    }
}
