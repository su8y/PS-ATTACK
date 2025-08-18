/*
 * 문제: 백준 2460번 - 지능형 기차 2 (https://www.acmicpc.net/problem/2460)
 *
 * 시간 복잡도: O(n) - n: 역의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2460_지능형기차2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int people = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            people += b - a;
            max = Math.max(max, people);
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
