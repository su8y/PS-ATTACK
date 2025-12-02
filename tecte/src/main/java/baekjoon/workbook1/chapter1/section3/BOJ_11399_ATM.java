/*
 * 문제: 백준 11399번 - ATM (https://www.acmicpc.net/problem/11399)
 *
 * 시간 복잡도: O(n log n)
 */

package baekjoon.workbook1.chapter1.section3;

import java.io.*;
import java.util.*;

public class BOJ_11399_ATM {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[n];
        int tSum = 0;
        int sum = 0;

        for (int i = 0; i < n; i++)
            time[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(time);

        for (int t : time) {
            sum += tSum + t;
            tSum += t;
        }

        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
