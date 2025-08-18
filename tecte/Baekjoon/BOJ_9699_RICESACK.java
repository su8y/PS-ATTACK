/*
 * 문제 : 백준 9699번 - RICE SACK (https://www.acmicpc.net/problem/9699)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_9699_RICESACK {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int rice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).max().getAsInt();

            bw.write("Case #" + i + ": " + rice + "\n");
        }

        br.close();
        bw.close();
    }
}
