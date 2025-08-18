/*
 * 문제 : 백준 2558번 - A+B - 2 (https://www.acmicpc.net/problem/2558)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2558_AB2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) + "");
        br.close();
        bw.close();
    }
}
