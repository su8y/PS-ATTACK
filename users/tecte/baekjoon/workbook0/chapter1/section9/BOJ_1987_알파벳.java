/*
 * 문제: 백준 1987번 - 알파벳 (https://www.acmicpc.net/problem/1987)
 * 문제 풀이
 *  DFS을 사용하여 다음 이동할 곳의 알파벳이 이미 지나온 길의 알파벳인지 확인하고
 *  지나온 알파벳이 아니면 이동, 지나온 알파벳이면 다른 곳을 확인하여 이동.
 *
 * 시간 복잡도: O(r * c)
 */

package baekjoon.workbook0.chapter1.section9;

import java.io.*;
import java.util.stream.*;

public class BOJ_1987_알파벳 {
    // public class  Main {
    private static int r;
    private static int c;
    private static int[][] board;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int move(int x, int y, int p) {
        p |= 1 << (board[x][y] - (int) 'a');

        int moveCnt = Integer.bitCount(p);

        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || my < 0 || mx >= r || my >= c)
                continue;

            if ((p & (1 << (board[mx][my] - (int) 'a'))) == 0)
                moveCnt = Math.max(move(mx, my, p), moveCnt);
        }

        return moveCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        board = new int[r][c];

        for (int i = 0; i < r; i++)
            board[i] = Stream.of(br.readLine().split("")).flatMapToInt(String::chars).toArray();

        bw.write(Integer.toString(move(0, 0, 0)));
        br.close();
        bw.close();
    }
}
