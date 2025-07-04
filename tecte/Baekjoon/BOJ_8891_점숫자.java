/*
 * 문제: 백준 8891번 - 점 숫자 (https://www.acmicpc.net/problem/8891)
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_8891_점숫자 {
    // public class Main {
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
        int t = Integer.parseInt(br.readLine());
        final int max = 10_000;
        Pos[] pos = new Pos[max];
        int x = 1;
        int y = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < max; i++) {
            pos[i] = new Pos(x, y);

            if (y == 1) {
                y = x + 1;
                x = 1;
            } else {
                x++;
                y--;
            }
        }

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            x = pos[a].x + pos[b].x;
            y = pos[a].y + pos[b].y;
            sb.append(((x + y - 2) * (x + y - 1) >> 1) + x).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
