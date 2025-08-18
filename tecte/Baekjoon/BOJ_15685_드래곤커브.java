/*
 * 문제: 백준 15685번 - 드래곤 커브 (https://www.acmicpc.net/problem/15685)
 * 문제 풀이
 *  이전 세대를 역순으로 올라가며 방향을 반시계 방향으로 90도 꺽고 드래곤 커브를 그림.
 *  드래곤 커브를 그리고 해당 방향을 리스트에 추가.
 *  드래곤 커브의 개수만큼 반복하고 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수를 구함.
 *
 * 시간 복잡도: O(n * 2^g)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
    // public class Main {
    private static boolean[][] board = new boolean[101][101];
    private static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    private static void DragonCurve(int x, int y, int g, List<Integer> list) {
        for (int i = 0; i < g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                int d = (list.get(j) + 1) % 4;

                x += dir[d][0];
                y += dir[d][1];
                board[x][y] = true;
                list.add(d);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            board[x][y] = true;
            x += dir[d][0];
            y += dir[d][1];
            board[x][y] = true;
            list.add(d);
            DragonCurve(x, y, g, list);
        }

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1])
                    cnt++;

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
