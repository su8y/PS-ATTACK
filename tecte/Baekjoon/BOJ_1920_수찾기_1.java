/*
 * 문제 : 백준 1920번 - 수 찾기 (https://www.acmicpc.net/problem/1920)
 * 문제 풀이
 *  이진 탐색을 사용한 방법
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기_1 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] na = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            na[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] ma = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++)
            ma[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(na);

        for (int i : ma) {
            bw.write(Arrays.binarySearch(na, i) >= 0 ? "1" : "0");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
