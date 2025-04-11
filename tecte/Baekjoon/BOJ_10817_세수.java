/*
 * 문제: 백준 10817번 - 세 수 (https://www.acmicpc.net/problem/10817)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10817_세수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result;

        if (a > b) {
            result = b > c ? b : Math.min(a, c);
        } else {
            result = a > c ? a : Math.min(b, c);
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
