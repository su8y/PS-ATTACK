/*
 * 문제 : 백준 20061번 - 모노미노도미노 2 (https://www.acmicpc.net/problem/20061)
 *  가로 보드를 시계 방향으로 90도 돌려 세로 보드 2개로 생각함
 *  2차원 배열보다는 행을 비트로 해서 1차원 배열로 보드 생성
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20061_모노미노도미노2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] green = new int[6];
        int[] blue = new int[6];
        int score = 0;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            switch (t) {
                case 1:
                    score += putBlock(green, 1, 1 << (3 - y));
                    score += putBlock(blue, 1, 1 << x);
                    break;
                case 2:
                    score += putBlock(green, 2, 3 << (2 - y));
                    score += putBlock(blue, 3, 1 << x);
                    break;
                case 3:
                    score += putBlock(green, 3, 1 << (3 - y));
                    score += putBlock(blue, 2, 3 << x);
                    break;
            }
        }

        bw.write(score + "\n");
        bw.write(blockCnt(green) + blockCnt(blue) + "");
        br.close();
        bw.close();
    }

    public static int putBlock(int[] board, int type, int block) {
        int score = 0;

        for (int i = 1; i < 6; i++) {
            if (i == 5 || (block & board[i + 1]) != 0) {
                board[i] |= block;

                if (type == 3) {
                    board[i - 1] |= block;
                    score += getScore(board, i - 1);
                }

                score += getScore(board, i);
                break;
            }
        }

        while (board[1] != 0) {
            for (int i = 0; i < 5; i++)
                board[5 - i] = board[4 - i];

            board[0] = 0;
        }

        return score;
    }

    public static int getScore(int[] board, int line) {
        if (board[line] == (1 << 4) - 1) {
            for (int i = line; i > 0; i--)
                board[i] = board[i - 1];

            board[0] = 0;

            return 1;
        }

        return 0;
    }

    public static int blockCnt(int[] board) {
        int cnt = 0;

        for (int line : board)
            cnt += Integer.bitCount(line);

        return cnt;
    }
}
