/*
 * 문제: 백준 1019번 - 책 페이지 (https://www.acmicpc.net/problem/1019)
 * 문제 풀이
 *  각 숫자가 자릿수별로 몇 번 오는지 계산.
 *  현재 자릿수의 앞자리 수, 현재 자릿수, 현재 자릿수의 뒷자리 수로 나눔.
 *  앞자리 수에 따라 0~9가 반복적으로 등장하는 횟수를 구하고 현재 자릿수의 값에 따라 추가로 등장하는 횟수를 더함.
 *  이때, 맨 앞자리에 0이 오는 경우를 뺌.
 *
 * 시간 복잡도: O(log₁₀ n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_1019_책페이지 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; n / i > 0; i *= 10) {
            int left = n / (i * 10);
            int right = n % i;
            int curr = n / i % 10;

            for (int j = 0; j < 10; j++) {
                cnt[j] += left * i;
            }

            for (int j = 0; j < curr; j++) {
                cnt[j] += i;
            }

            cnt[curr] += right + 1;
            cnt[0] -= i;
        }

        for (int c : cnt) {
            sb.append(c).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
