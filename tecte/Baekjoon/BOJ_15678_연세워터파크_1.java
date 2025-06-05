/*
 * 문제: 백준 15678번 - 연세워터파크 (https://www.acmicpc.net/problem/15678)
 * 문제 풀이
 *  세그먼트 트리를 이용한 DP 최적화 문제.
 *  각 위치를 마지막으로 하는 최대 누적합을 구하기 위해, d칸 이내 이전 구간의 최대 누적합을 세그먼트 트리로 구해서 현재 값과 더함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15678_연세워터파크_1 {
    // public class Main {
    private static long[] seg;

    private static long query(int n, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 0;
        } else if (s >= l && e <= r) {
            return seg[n];
        } else {
            int c = n << 1;
            int m = (s + e) >> 1;

            return Math.max(query(c, s, m, l, r), query(c + 1, m + 1, e, l, r));
        }
    }

    private static void update(int n, int s, int e, int i, long v) {
        if (s == e) {
            seg[n] = v;
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            if (s <= i && i <= m) {
                update(l, s, m, i, v);
            } else {
                update(r, m + 1, e, i, v);
            }

            seg[n] = Math.max(seg[l], seg[r]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        long max = Long.MIN_VALUE;

        seg = new long[n << 2];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int s = Integer.parseInt(st.nextToken());
            long m = query(1, 1, n, Math.max(1, i - d), i) + s;

            update(1, 1, n, i, m);
            max = Math.max(max, m);
        }

        bw.write(Long.toString(max));
        br.close();
        bw.close();
    }
}
