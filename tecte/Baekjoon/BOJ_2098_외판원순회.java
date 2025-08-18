/*
 * 문제: 백준 2098번 - 외판원 순회 (https://www.acmicpc.net/problem/2098)
 * 문제 풀이
 * 	완전탐색으로 생각할 경우 시간복잡도가 O(n!)이기 때문에 dp를 이용하여 시간복잡도를 줄임.
 * 	예를 들어 도시 0,1,2,3,4,5가 있다고 가정했을 때,
 * 	0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 0이 최소 비용 경로라는 것을 알고 있으면
 * 	0 -> 2 -> 1 -> 3 상황에서는 위의 경로를 통해 4 -> 5 -> 0이 비용이 가장 적게 든다는 것을 알기 때문에
 * 	0 -> 2 -> 1 -> 3 -> 4 -> 5 -> 0이 최소 비용이라는 것을 알 수 있음.
 * 	이 알고리즘을 적용하려면 남은 도시에 따른 최소 비용을 배열에 저장해야 함.
 * 	n(도시의 수)이 커지면 배열 크기 문제로 사용할 수 없지만 이 문제는 n이 최대 16이여서 괜찮음.
 * 	n이 최대 16이기 때문에 배열 대신 비트 마스크를 사용하면 int형 변수로 표현할 수 있음.
 *
 * 시간 복잡도: O(n^2 * 2^n)
 */

package Baekjoon;

import java.io.*;
import java.util.stream.*;

public class BOJ_2098_외판원순회 {
    // public class Main {
    private static int n;
    private static int[][] w;
    private static int[][] dp;

    private static int tsp(int c, int v) {
        if (v == (1 << n) - 1) {
            return w[c][0] == 0 ? -1 : w[c][0];
        } else if (dp[c][v] != 0) {
            return dp[c][v];
        }

        for (int i = 0; i < n; i++) {
            if ((v & 1 << i) == 0 && w[c][i] != 0) {
                int nextCity = tsp(i, (v | 1 << i));

                if (nextCity == -1) {
                    continue;
                }

                if (dp[c][v] == 0) {
                    dp[c][v] = nextCity + w[c][i];
                } else if (dp[c][v] > 0) {
                    dp[c][v] = Math.min(dp[c][v], nextCity + w[c][i]);
                }
            }
        }

        if (dp[c][v] == 0) {
            dp[c][v] = -1;
        }

        return dp[c][v];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            w[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(Integer.toString(tsp(0, 1)));
        br.close();
        bw.close();
    }
}
