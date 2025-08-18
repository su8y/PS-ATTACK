/*
 * 문제: 백준 11005번 - 진법 변환 2 (https://www.acmicpc.net/problem/11005)
 *
 * 시간 복잡도: O(log n) - n:
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11005_진법변환2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(n, b).toUpperCase());
        br.close();
        bw.close();
    }
}
