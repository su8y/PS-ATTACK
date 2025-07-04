/*
 * 문제: 백준 3135번 - 라디오 (https://www.acmicpc.net/problem/3135)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3135_라디오 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int min = Math.abs(a - b);

        for (int i = 0; i < n; i++) {
            min = Math.min(min, 1 + Math.abs(b - Integer.parseInt(br.readLine())));
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }
}
