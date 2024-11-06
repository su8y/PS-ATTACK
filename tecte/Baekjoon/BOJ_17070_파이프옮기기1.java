/*
 * 문제 : 백준 17070번 - 파이프 옮기기 1 (https://www.acmicpc.net/problem/17070)
 * 문제 풀이
 *  DP를 사용하여 파이프의 방향에 따라 메모이제이션 함.
 *  (N, N)에 → 방향으로 파이프가 올 수 있는 경우는 (N, N-1)에서 →, ↘ 방향의 파이프만 올 수 있음.
 *  ↘ 방향으로 파이프가 올 수 있는 경우는 (N-1, N-1)에서 →, ↘, ↓ 방향의 파이프만 올 수 있음.
 *  이 때 (N-1, N), (N, N-1)이 벽이 아니어야 함.
 *  ↓ 방향으로 파이프가 올 수 있는 경우는 (N-1, N)에서 ↘, ↓ 방향의 파이프만 올 수 있음.
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_17070_파이프옮기기1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] home = new int[n + 1][n];
        int[][][] pipe = new int[n + 1][n][3];

        for (int i = 1; i <= n; i++)
            home[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        pipe[1][1][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < n; j++) {
                if (home[i][j] == 1)
                    continue;

                pipe[i][j][0] = pipe[i][j - 1][0] + pipe[i][j - 1][1];
                pipe[i][j][2] = pipe[i - 1][j][1] + pipe[i - 1][j][2];

                if (home[i - 1][j] == 0 && home[i][j - 1] == 0)
                    pipe[i][j][1] = pipe[i - 1][j - 1][0] + pipe[i - 1][j - 1][1] + pipe[i - 1][j - 1][2];
            }
        }

        bw.write(Integer.toString(pipe[n][n - 1][0] + pipe[n][n - 1][1] + pipe[n][n - 1][2]));
        br.close();
        bw.close();
    }
}
