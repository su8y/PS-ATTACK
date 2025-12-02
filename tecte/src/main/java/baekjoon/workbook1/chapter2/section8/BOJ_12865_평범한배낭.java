/*
 * 문제: 백준 12865번 - 평범한 배낭 (https://www.acmicpc.net/problem/12865)
 * 문제 풀이
 * 	입력받은 값을 무게를 기준으로 정렬하고 n(개수)*w(무게)의 2차원 배열 dp를 만들어 최적의 가치 값을 저장.
 * 	최적의 값은 원소의 무게 + dp의 인덱스가 (최대 무게-원소의 무게)인 값.
 *
 * 시간 복잡도: O(n * w)
 */

package baekjoon.workbook1.chapter2.section8;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BOJ_12865_평범한배낭 {
    // public class Main	{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nw[] = br.readLine().split(" ");
        int n = Integer.parseInt(nw[0]);
        int w = Integer.parseInt(nw[1]);
        int item[][] = new int[n + 1][2];

        for (int i = 1; i <= n; i++)
            item[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(item, Comparator.comparingInt((int[] o) -> o[0]));

        int dp[][] = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            int iw = item[i][0];
            int iv = item[i][1];

            for (int j = item[1][0]; j <= w; j++) {
                if (iw > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max((iv + dp[i - 1][j - iw]), dp[i - 1][j]);
            }
        }

        bw.write(Integer.toString(dp[n][w]));
        br.close();
        bw.close();
    }
}
