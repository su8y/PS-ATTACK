/*
 * 문제: 백준 11501번 - 주식 (https://www.acmicpc.net/problem/11501)
 * 문제 풀이
 *  lds로 날 별 주가의 판매일을 구해서 최대 이익을 구함.
 *
 * 시간 복잡도: O(t * n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_11501_주식_1 {
    // public class Main {
    static int[] stockPrice;
    static int[] sellTime;
    static int pos = 0;

    static int lowerBound(int key) {
        int left = 0;
        int right = pos + 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (stockPrice[sellTime[mid]] > stockPrice[key])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            stockPrice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sellTime = new int[n];
            long profit = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                pos = lowerBound(i);
                sellTime[pos] = i;
            }

            for (int i=0,j=0;i<n && j<=pos;i++) {
                if (i==sellTime[j]) {
                    profit += (long) stockPrice[i] * cnt;
                    cnt = 0;
                    j++;
                } else {
                    profit -= stockPrice[i];
                    cnt++;
                }
            }

            bw.write(Long.toString(profit));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
