/*
 * 문제: 백준 1799번 - 비숍 (https://www.acmicpc.net/problem/1799)
 * 문제 풀이
 *  체스판을 시계방향으로 45도 돌려서 마름모 모양으로 생각하면 비숍의 이동방향도 직선으로 바뀜.
 *  백트래킹을 하면서 비숍을 놓을 수 있는 위치인지 확인하고, 수직방향에 다른 비숍이 있는지 확인.
 *  현재 위치에서 추가로 배치 가능한 비숍의 개수가 현재까지 구한 비숍의 최대 개수를 초과할 수 없는 경우 탐색을 종료하여 가지치기를 함.
 *
 * 시간 복잡도: O(2^(n / 2))
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1799_비숍 {
    // public class Main {
    private static int n;
    private static int[] board;
    private static int diag = 0;
    private static int max = 0;

    private static void dfs(int x, int y, int cnt, boolean isWhite) {
        if (y == n) {
            if (++x == n) {
                max = Math.max(max, cnt);

                return;
            }

            y--;
        }

        if ((n << 1) - 1 - x - y + cnt <= max) {
            return;
        }

        int nx = x;
        int ny = y;

        while (nx < n && ny >= 0) {
            int mask = 1 << (nx + n - ny);

            if ((board[nx] & (1 << ny)) != 0 && (diag & mask) == 0) {
                diag |= mask;
                dfs(x, y + 1, cnt + 1, !isWhite);
                diag ^= mask;
            }

            nx++;
            ny--;
        }

        dfs(x, y + 1, cnt, !isWhite);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i] |= Integer.parseInt(st.nextToken()) << j;
            }
        }

        dfs(0, 0, 0, true);
        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
