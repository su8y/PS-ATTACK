/*
 * 문제 : 백준 18111번 - 마인크래프트 (https://www.acmicpc.net/problem/18111)
 * 문제 풀이
 *  가장 높은 땅 높이에서부터 높이가 0이 될 때까지 해당 높이로 만드는데 걸리는 시간을 구함
 *  현재 높이를 만드는 시간과 전 높이를 만드는 시간을 비교해서 더 짧으면 갱신하고 아니면 전 시간과 높이 출력
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        int height = 0;
        int time = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, field[i][j]);
            }
        }

        do {
            int add = 0;
            int remove = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (field[i][j] > height) {
                        remove += field[i][j] - height;
                    } else if (field[i][j] < height) {
                        add += height - field[i][j];
                    }
                }
            }

            if (remove + b >= add) {
                int newTime = remove * 2 + add;

                if (newTime < time)
                    time = newTime;
                else
                    break;
            }

        } while (--height >= 0);

        bw.write(time + " " + (height + 1));
        br.close();
        bw.close();
    }
}
