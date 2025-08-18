/*
 * 문제 : 백준 18110번 - solved.ac (https://www.acmicpc.net/problem/18110)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_18110_solvedac {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] opinion = new int[n];

        for (int i = 0; i < n; i++)
            opinion[i] = Integer.parseInt(br.readLine());

        Arrays.sort(opinion);

        int exclusion = (int) Math.round(n * .15);
        int sum = 0;

        for (int i = exclusion; i < n - exclusion; i++)
            sum += opinion[i];

        bw.write(Math.round(sum / (n - exclusion * 2.)) + "");
        br.close();
        bw.close();
    }
}
