/*
 * 문제: 백준 25628번 - 햄버거 만들기 (https://www.acmicpc.net/problem/25628)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25628_햄버거만들기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(Math.min(b / 2, p)));
        br.close();
        bw.close();
    }
}
