/*
 * 문제 : 백준 28281번 - 선물 (https://www.acmicpc.net/problem/28281)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_28281_선물 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] socks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int price = Integer.MAX_VALUE;

        for (int i = 0; i < socks.length - 1; i++)
            price = Math.min(price, socks[i] + socks[i + 1]);

        bw.write(Integer.toString(price * x));
        br.close();
        bw.close();
    }
}
