/*
 * 문제: 백준 4999번 - 아! (https://www.acmicpc.net/problem/4999)
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;

public class BOJ_4999_아 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String j = br.readLine();
        String d = br.readLine();

        bw.write(j.length() < d.length() ? "no" : "go");
        br.close();
        bw.close();
    }
}
