/*
 * 문제: 백준 11501번 - 주식 (https://www.acmicpc.net/problem/11501)
 * 문제 풀이
 *  날 별 주가를 마지막에서 첫 번째까지 역으로 돌면서 최대 가격을 구하고
 *  최대 가격을 갱신하지 못하면 최대 가격에서 해당 날의 가격을 빼서 이익을 구함.
 *
 * 시간 복잡도: O(t * n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_11501_주식_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long profit = 0;
            int max = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (max < price[i])
                    max = price[i];
                else
                    profit += max - price[i];
            }

            bw.write(Long.toString(profit));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
