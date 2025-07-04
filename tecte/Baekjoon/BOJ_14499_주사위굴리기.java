/*
 * 문제: 백준 14499번 - 주사위 굴리기 (https://www.acmicpc.net/problem/14499)
 *
 * 시간 복잡도: O(k)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
    // public class Main {
    private static class Dice {
        int top, bottom, left, right, front, back;
        int x, y;

        public Dice(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move(int d) {
            int temp = front;

            if (d == 1) {
                front = left;
                left = back;
                back = right;
                right = temp;
            } else if (d == 2) {
                front = right;
                right = back;
                back = left;
                left = temp;
            } else if (d == 3) {
                front = bottom;
                bottom = back;
                back = top;
                top = temp;
            } else {
                front = top;
                top = back;
                back = bottom;
                bottom = temp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Dice dice = new Dice(x, y);

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int d : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            int nx = dice.x + dir[d][0];
            int ny = dice.y + dir[d][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;

            dice.x = nx;
            dice.y = ny;
            dice.move(d);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice.back;
            } else {
                dice.back = map[nx][ny];
                map[nx][ny] = 0;
            }

            bw.write(Integer.toString(dice.front));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
