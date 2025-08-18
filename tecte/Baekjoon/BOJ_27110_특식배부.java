/*
 * 문제 : 백준 27110번 - 특식 배부 (https://www.acmicpc.net/problem/27110)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_27110_특식배부 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = 0;

        for (int i = 0; i < 3; i++)
            total += Math.min(p[i], n);

        bw.write(total + "");
        br.close();
        bw.close();
    }
}
