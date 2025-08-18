/*
 * 문제: 백준 3003번 - 킹, 퀸, 룩, 비숍, 나이트, 폰 (https://www.acmicpc.net/problem/3003)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3003_킹퀸룩비숍나이트폰 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        bw.write((1 - k) + " " + (1 - q) + " " + (2 - r) + " " + (2 - b) + " " + (2 - n) + " " + (8 - p));
        br.close();
        bw.close();
    }
}
