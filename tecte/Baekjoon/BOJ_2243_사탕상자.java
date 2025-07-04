/*
 * 문제: 백준 2243번 - 사탕상자 (https://www.acmicpc.net/problem/2243)
 * 문제 풀이
 *  세그먼트 트리를 사용하여 사탕의 개수를 누적합 형태로 관리하고 이분 탐색으로 원하는 사탕을 찾고 수정함.
 *
 * 시간 복잡도: O(n log m) - m: 사탕 맛의 범위
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2243_사탕상자 {
    // public class Main {
    private static final int MAX = 1_000_000;
    private static int[] seg = new int[MAX << 2];

    private static int query(int n, int s, int e, int v) {
        if (s == e) {
            return s;
        }

        int c = n << 1;
        int m = (s + e) >> 1;

        return seg[c] < v ? query(c + 1, m + 1, e, v - seg[c]) : query(c, s, m, v);
    }

    private static void update(int n, int s, int e, int i, int v) {
        if (s == e) {
            seg[n] += v;
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            if (s <= i && i <= m) {
                update(l, s, m, i, v);
            } else {
                update(r, m + 1, e, i, v);
            }

            seg[n] = seg[l] + seg[r];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                int b = Integer.parseInt(st.nextToken());
                int candy = query(1, 1, MAX, b);

                update(1, 1, MAX, candy, -1);
                sb.append(candy).append("\n");
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                update(1, 1, MAX, b, c);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
