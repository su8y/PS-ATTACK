/*
 * 문제: 백준 13458번 - 시험 감독 (https://www.acmicpc.net/problem/13458)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] candidate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long total = 0;

        for (int i = 0; i < n; i++) {
            if (candidate[i] < b)
                total++;
            else
                total += (candidate[i] - b + c - 1) / c + 1;
        }

        bw.write(Long.toString(total));
        br.close();
        bw.close();
    }
}
