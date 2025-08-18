/*
 * 문제 : 백준 9724번 - Perfect Cube (https://www.acmicpc.net/problem/9724)
 */

package Baekjoon;

import java.io.*;

public class BOJ_9724_PerfectCube {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]);

            bw.write("Case #" + i + ": " + ((int) Math.cbrt(b) - (int) Math.cbrt(a)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
