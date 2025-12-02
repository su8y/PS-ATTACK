/*
 * 문제: 백준 1920번 - 수 찾기 (https://www.acmicpc.net/problem/1920)
 * 문제 풀이
 *  hashSet을 사용한 방법.
 *
 * 시간 복잡도: O(n + m)
 */

package baekjoon.workbook0.chapter1.section9;

import java.io.*;
import java.util.*;

public class BOJ_1920_수찾기_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            set.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        int[] ma = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            bw.write(set.contains(Integer.parseInt(st.nextToken())) ? "1" : "0");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
