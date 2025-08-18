/*
 * 문제: 백준 14500번 - 테트로미노 (https://www.acmicpc.net/problem/14500)
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_14500_테트로미노 {
    // public class Main {
    static int n, m;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        paper = new int[n][];
        int max = 0;

        for (int i = 0; i < n; i++)
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                max = Math.max(max, link(i, j, 1, true));

        bw.write(max + "");
        br.close();
        bw.close();
    }

    public static int link(int x, int y, int cnt, boolean t) {
        if (cnt > 4)
            return 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int sum = 0;
        int num = paper[x][y];

        paper[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (paper[nx][ny] != 0)
                    sum = Math.max(sum, link(nx, ny, cnt + 1, t));
                else if (cnt == 3 && t)
                    sum = Math.max(sum, link(nx, ny, cnt, false));
            }
        }

        paper[x][y] = num;

        return num + sum;
    }
}
