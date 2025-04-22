/*
 * 문제: 백준 6887번 - Squares (https://www.acmicpc.net/problem/6887)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_6887_Squares {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("The largest square has side length ");
        int cnt = Integer.parseInt(br.readLine());

        sb.append((int) Math.sqrt(cnt)).append('.');
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
