/*
 * 문제: 백준 1806번 - 부분합 (https://www.acmicpc.net/problem/1806)
 * 문제 풀이
 *  투 포인터를 사용해서 현재 구간의 합이 s 이상이 될 때마다 가장 짧은 길이인지 확인하고 구간 이동.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

        while (right <= n) {
            if (sum[right] - sum[left] < s) {
                right++;
                continue;
            }

            len = Math.min(len, right - left);
            left++;
        }

        bw.write(Integer.toString(len % Integer.MAX_VALUE));
        br.close();
        bw.close();
    }
}
