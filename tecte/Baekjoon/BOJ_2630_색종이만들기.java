/*
 * 문제 : 백준 2630번 - 색종이 만들기 (https://www.acmicpc.net/problem/2630)
 * 문제 풀이
 *  분할 정복을 사용해서 품. 색이 하얀색과 파란색만 있으므로 int 배열대신 boolean 배열 사용
 */

package Baekjoon;

import java.io.*;

public class BOJ_2630_색종이만들기 {
    // public class Main {
    static boolean[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        paper = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");

            for (int j = 0; j < n; j++)
                paper[i][j] = row[j].equals("1");
        }

        cut(0, 0, n);
        bw.write(white + "");
        bw.newLine();
        bw.write(blue + "");
        br.close();
        bw.close();
    }

    public static void cut(int x, int y, int step) {
        int cnt = 0;

        for (int i = 0; i < step; i++)
            for (int j = 0; j < step; j++)
                if (paper[x + i][y + j])
                    cnt++;

        if (cnt == 0) {
            white++;
        } else if (cnt == step * step) {
            blue++;
        } else {
            step /= 2;
            cut(x, y, step);
            cut(x + step, y, step);
            cut(x, y + step, step);
            cut(x + step, y + step, step);
        }
    }
}
