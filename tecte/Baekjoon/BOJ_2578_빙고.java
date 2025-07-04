/*
 * 문제: 백준 2578번 - 빙고 (https://www.acmicpc.net/problem/2578)
 *
 * 시간 복잡도: O(n^3) - n: 빙고판의 가로줄 또는 세로줄의 칸 수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2578_빙고 {
    // public class Main {
    private static final int N = 5;
    private static Pos[] nums = new Pos[N * N + 1];
    private static int[] visited = new int[N];

    private static int rowCheck(Pos pos) {
        return visited[pos.x] == (1 << N) - 1 ? 1 : 0;
    }

    private static int colCheck(Pos pos) {
        int mask = 1 << pos.y;

        for (int i = 0; i < N; i++) {
            if ((visited[i] & mask) == 0) {
                return 0;
            }
        }

        return 1;
    }

    private static int diagCheck() {
        for (int i = 0; i < N; i++) {
            if ((visited[i] & (1 << i)) == 0) {
                return 0;
            }
        }

        return 1;
    }

    private static int antiDiagCheck() {
        for (int i = 0; i < N; i++) {
            if ((visited[i] & (1 << (N - 1 - i))) == 0) {
                return 0;
            }
        }

        return 1;
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int bingo = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                nums[Integer.parseInt(st.nextToken())] = new Pos(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                Pos pos = nums[a];

                visited[pos.x] |= 1 << pos.y;
                bingo += rowCheck(pos) + colCheck(pos);

                if (bingo + diagCheck() + antiDiagCheck() >= 3 && result == 0) {
                    result = i * N + j + 1;
                }
            }
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
