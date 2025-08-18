/*
 * 문제: 백준 17825번 - 주사위 윷놀이 (https://www.acmicpc.net/problem/17825)
 *
 * 시간 복잡도: O(4^10)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_17825_주사위윷놀이 {
    // public class Main {
    private static int[] nums;
    private static Cell[] pieces = new Cell[4];
    private static int max = 0;

    private static void dfs(int depth, int score) {
        if (depth == 10) {
            max = Math.max(max, score);

            return;
        }

        for (int i = 0; i < 4; i++) {
            Cell origin = pieces[i];
            Cell piece = origin;

            if (piece.next == null) {
                continue;
            } else if (piece.bNext == null) {
                piece = piece.next;
            } else {
                piece = piece.bNext;
            }

            for (int j = 1; j < nums[depth]; j++) {
                if (piece.next == null) {
                    break;
                }

                piece = piece.next;
            }

            if (piece.next != null) {
                boolean flag = false;

                for (int j = 0; j < 4; j++) {
                    if (i != j && pieces[j] == piece) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    continue;
                }
            }

            pieces[i] = piece;
            dfs(depth + 1, score + piece.score);
            pieces[i] = origin;
        }
    }

    private static class Cell {
        int score;
        Cell next, bNext;

        public Cell(int score, Cell next) {
            this.score = score;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Cell next = new Cell(40, new Cell(0, null));
        Cell bNext = new Cell(25, new Cell(30, new Cell(35, next)));

        while (next.score > 0) {
            next = new Cell(next.score - 2, next);

            if (next.score == 30) {
                next.bNext = new Cell(28, new Cell(27, new Cell(26, bNext)));
            } else if (next.score == 20) {
                next.bNext = new Cell(22, new Cell(24, bNext));
            } else if (next.score == 10) {
                next.bNext = new Cell(13, new Cell(16, new Cell(19, bNext)));
            }
        }

        for (int i = 0; i < 4; i++) {
            pieces[i] = next;
        }

        dfs(0, 0);
        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
