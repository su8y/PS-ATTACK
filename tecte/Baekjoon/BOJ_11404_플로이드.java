/*
 * 문제 : 백준 11404번 - 플로이드 (https://www.acmicpc.net/problem/11404)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_11404_플로이드 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = Math.min(city[input[0]][input[1]], input[2]);

            city[input[0]][input[1]] = w == 0 ? input[2] : w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (city[i][k] == 0)
                    continue;

                for (int j = 1; j <= n; j++) {
                    if (i == j || city[k][j] == 0)
                        continue;

                    if (city[i][j] == 0)
                        city[i][j] = city[i][k] + city[k][j];
                    else
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                bw.write(city[i][j] + " ");

            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
