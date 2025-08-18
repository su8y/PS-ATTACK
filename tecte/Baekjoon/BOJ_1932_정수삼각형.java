/*
 * 문제 : 백준 1932번 - 정수 삼각형 (https://www.acmicpc.net/problem/1932)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1932_정수삼각형 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++)
            triangle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = n - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);

        bw.write(triangle[0][0] + "");
        br.close();
        bw.close();
    }
}
