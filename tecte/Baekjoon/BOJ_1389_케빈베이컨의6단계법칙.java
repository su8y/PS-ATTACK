/*
 * 문제 : 백준 1389번 - 케빈 베이컨의 6단계 법칙 (https://www.acmicpc.net/problem/1389)
 * 문제 풀이
 *  플로이드 워셜 알고리즘을 사용하여 모든 정점에서 다른 모든 정점까지의 최단 경로를 합을 구하여 가장 작은 값을 가진 정점을 출력
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] relationship = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i != j)
                    relationship[i][j] = 10000;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relationship[x][y] = 1;
            relationship[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i)
                    continue;

                for (int j = 1; j <= n; j++)
                    if (i != j)
                        relationship[i][j] = Math.min(relationship[i][j], relationship[i][k] + relationship[k][j]);
            }
        }

        int person = 0;
        int minStep = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int step = 0;

            for (int j = 1; j <= n; j++)
                step += relationship[i][j];

            if (step < minStep) {
                person = i;
                minStep = step;
            }
        }

        bw.write(person + "");
        br.close();
        bw.close();
    }
}
