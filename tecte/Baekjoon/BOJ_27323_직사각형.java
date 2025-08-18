/*
 * 문제 : 백준 27323번 - 직사각형 (https://www.acmicpc.net/problem/27323)
 */

package Baekjoon;

import java.io.*;

public class BOJ_27323_직사각형 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        bw.write(a * b + "");
        br.close();
        bw.close();
    }
}
