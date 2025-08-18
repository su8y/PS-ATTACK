/*
 * 문제: 백준 12100번 - 2048 (Easy) (https://www.acmicpc.net/problem/12100)
 * 문제 풀이
 *  DFS로 모든 경우의 이동을 시뮬레이션 함.
 *
 * 시간 복잡도: O(4^5 * n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_12100_2048Easy {
    // public class Main {
    private static int n;
    private static int max = 0;

    private static void move(int[][] board, boolean[][] summed, int x, int y, int num, int[] dir) {
        while (true) {
            x += dir[0];
            y += dir[1];

            if (x < 0 || x >= n || y < 0 || y >= n || (board[x][y] != 0 && board[x][y] != num) || summed[x][y]) {
                board[x - dir[0]][y - dir[1]] = num;
                break;
            } else if (board[x][y] == num) {
                board[x][y] += num;
                summed[x][y] = true;
                break;
            }
        }
    }

    private static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            max = Math.max(max, Arrays.stream(board).flatMapToInt(Arrays::stream).max().orElse(0));

            return;
        }

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] newBoard = new int[n][n];
        boolean[][] summed = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] != 0)
                    move(newBoard, summed, i, j, board[i][j], dir[0]);

        dfs(depth + 1, newBoard);
        newBoard = new int[n][n];
        summed = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                if (board[j][i] != 0)
                    move(newBoard, summed, j, i, board[j][i], dir[1]);

        dfs(depth + 1, newBoard);
        newBoard = new int[n][n];
        summed = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                if (board[i][j] != 0)
                    move(newBoard, summed, i, j, board[i][j], dir[2]);

        dfs(depth + 1, newBoard);
        newBoard = new int[n][n];
        summed = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[j][i] != 0)
                    move(newBoard, summed, j, i, board[j][i], dir[3]);

        dfs(depth + 1, newBoard);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, board);
        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
