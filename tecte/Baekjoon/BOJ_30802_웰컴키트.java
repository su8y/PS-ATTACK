/*
 * 문 제 : 백준 30802번 - 웰컴 키트 (https://www.acmicpc.net/problem/30802)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_30802_웰컴키트 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] bundle = br.readLine().split(" ");
        int t = Integer.parseInt(bundle[0]);
        int p = Integer.parseInt(bundle[1]);
        int tBundle = 0;

        for (int size : sizes)
            tBundle += (size + t - 1) / t;

        bw.write("" + tBundle);
        bw.newLine();
        bw.write((n / p) + " " + (n % p));

        br.close();
        bw.close();
    }
}
