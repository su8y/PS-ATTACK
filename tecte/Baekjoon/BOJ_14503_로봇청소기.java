/*
 * 문제: 백준 0000번 - 0000 (https://www.acmicpc.net/problem/0000)
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] room = new int[n][m];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int clean = 0;

        for (int i = 0; i < n; i++)
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            boolean isMove = false;

            if (room[x][y] == 0) {
                room[x][y] = 2;
                clean++;
            }

            for (int i = 1; i < 5; i++) {
                int nd = (d + 4 - i) % 4;
                int nx = x + dir[nd][0];
                int ny = y + dir[nd][1];

                if (room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    d = nd;
                    isMove = true;

                    break;
                }
            }

            if (!isMove) {
                int nd = (d + 2) % 4;
                int nx = x + dir[nd][0];
                int ny = y + dir[nd][1];

                if (room[nx][ny] == 1)
                    break;

                x = nx;
                y = ny;
            }
        }

        bw.write(Integer.toString(clean));
        br.close();
        bw.close();
    }
}
