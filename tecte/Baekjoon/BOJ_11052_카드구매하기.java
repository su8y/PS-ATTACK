/*
 * 문제 : 백준 11052번 - 카드 구매하기 (https://www.acmicpc.net/problem/11052)
 * 문제 풀이
 * 	n개의 카드팩 비용을 배열 card에 저장하고 배열 dp에 지불해야 하는 금액의 최댓값을 저장
 * 	n개의 카드를 구매하기 위한 금액의 최댓값을 구하는 경우의 수는
 * 	card[n]+dp[0], card[n-1]+dp[1], card[n-2]+dp[2], ... 즉, card[n-i]+dp[i]가 있고
 * 	이중 가장 큰 값을 dp에 저장, dp를 1부터 n까지 점화식으로 구하면 n개의 카드를 구매하기 위한 금액의 최댓값을 구할 수 있음
 */

package Baekjoon;

import java.io.*;
import java.util.stream.Stream;

public class BOJ_11052_카드구매하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] card = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], card[i - j - 1] + dp[j]);

        bw.write(Integer.toString(dp[n]));
        bw.flush();

        br.close();
        bw.close();
    }
}
