/*
 * 문제: 백준 3190번 - 뱀 (https://www.acmicpc.net/problem/3190)
 *
 * 시간 복잡도: O(x)
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
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
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[][] isApple = new boolean[n+1][n+1];
        boolean[][] isSnake = new boolean[n+1][n+1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            isApple[x][y] = true;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Pos> snake = new LinkedList<>();
        char[] dirInfo = new char[10_001];
        Pos[] dir = {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
        int d = 1;
        int x = 1;
        int y = 1;

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            dirInfo[t] = c;
        }

        snake.offer(new Pos(x, y));

        for (int i = 1; i < dirInfo.length; i++) {
            x += dir[d].x;
            y += dir[d].y;

            if (x <= 0 || x > n || y <= 0 || y > n || isSnake[x][y]) {
                bw.write(Integer.toString(i));
                break;
            }

            snake.offer(new Pos(x, y));
            isSnake[x][y] = true;

            if (isApple[x][y]) {
                isApple[x][y] = false;
            } else {
                Pos pos = snake.poll();

                isSnake[pos.x][pos.y] = false;
            }

            if (dirInfo[i] == 'L')
                d = (d + 3) % 4;
            else if (dirInfo[i] == 'D')
                d = (d + 1) % 4;
        }

        br.close();
        bw.close();
    }
}
