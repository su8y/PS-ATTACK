/*
 * 문제: 백준 1027번 - 고층 건물 (https://www.acmicpc.net/problem/1027)
 * 문제 풀이
 *  각 빌딩마다 오른쪽에 있는 다른 빌딩들과 기울기를 계산.
 *  오른쪽으로 갈수록 기울기가 증가해야 다른 빌딩에 막히지 않고 서로 볼 수 있음.
 *  서로 볼 수 있는 빌딩들을 누적해서 가장 많이 보이는 빌딩을 구함.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1027_고층건물_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            double maxSlope = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);

                if (slope > maxSlope) {
                    cnt[i]++;
                    cnt[j]++;
                    maxSlope = slope;
                }
            }
        }

        bw.write(Integer.toString(Arrays.stream(cnt).max().orElse(0)));
        br.close();
        bw.close();
    }
}
