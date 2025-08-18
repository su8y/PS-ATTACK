/*
 * 문제 : 백준 1676번 - 팩토리얼 0의 개수 (https://www.acmicpc.net/problem/1676)
 * 문제 풀이
 *  N이 최대 500인데 500!는 int, long의 범위보다 큼
 *  끝의 0의 개수는 10의 개수를 세는 것으로 2와 5의 개수로 결정됨
 *  2의 개수가 5의 개수보다 많으므로 5의 개수만 세면 10의 개수를 셀 수 있음
 */


package Baekjoon;

import java.io.*;

public class BOJ_1676_팩토리얼0의개수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 5; i <= n; i *= 5) {
            cnt += n / i; // 5의 배수에 해당하는 개수 누적
        }

        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
