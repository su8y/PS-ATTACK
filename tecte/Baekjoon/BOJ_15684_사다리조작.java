/*
 * 문제: 백준 15684번 - 사다리 조작 (https://www.acmicpc.net/problem/15684)
 *
 * 시간 복잡도: O((n * h)^4)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
    // public class Main {
    private static int n, h;
    private static int[] ladder;

    private static boolean play() {
        for (int i = 0; i < n; i++) {
            int col = i;

            for (int j = 0; j < h; j++) {
                if ((ladder[col] & (1 << j)) != 0)
                    col++;
                else if (col > 0 && (ladder[col - 1] & (1 << j)) != 0)
                    col--;
            }

            if (col != i)
                return false;
        }

        return true;
    }

    private static int dfs(int depth) {
        int cnt = -1;

        if (depth <= 3) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < h; j++) {
                    int leg = 1 << j;
                    boolean flag = false;

                    if ((ladder[i] & leg) != 0 || (ladder[i + 1] & leg) != 0)
                        continue;

                    ladder[i] |= leg;
                    flag = play();

                    if (cnt == -1)
                        cnt = dfs(depth + 1);

                    ladder[i] ^= leg;

                    if (flag)
                        return depth;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            ladder[b] |= 1 << a;
        }

        bw.write(play() ? "0" : Integer.toString(dfs(1)));
        br.close();
        bw.close();
    }
}
