/*
 * 문제: 백준 22251번 - 빌런 호석 (https://www.acmicpc.net/problem/22251)
 * 문제 풀이
 *  0~9까지의 숫자가 다른 숫자로 바뀔 때 반전되는 LED의 개수를 배열에 미리 저장.
 *  1~N까지 반복하며 엘리베이터가 멈춰있는 층수와 각 자리의 숫자를 비교하며 반전되는 LED의 개수를 구함.
 *
 * 시간 복잡도: O(n * k)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22251_빌런호석 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] floor = new int[k];
        int[][] display = {
                {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
                {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
                {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
                {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
                {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
                {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
                {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
                {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
                {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
                {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
        };
        int cnt = -1;

        for (int i = 0; i < k; i++) {
            floor[i] = x % 10;
            x /= 10;
        }

        for (int i = 1; i <= n; i++) {
            int num = i;
            int led = 0;

            for (int j = 0; j < k; j++) {
                led += display[floor[j]][num % 10];
                num /= 10;
            }

            if (led <= p)
                cnt++;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
