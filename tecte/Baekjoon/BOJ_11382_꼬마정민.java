/*
 * 문제 : 백준 11382번 - 꼬마 정민 (https://www.acmicpc.net/problem/11382)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11382_꼬마정민 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + "");
        br.close();
        bw.close();
    }
}
