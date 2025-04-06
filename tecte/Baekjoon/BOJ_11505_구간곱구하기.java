/*
 * 문제: 백준 11505번 - 구간 곱 구하기 (https://www.acmicpc.net/problem/11505)
 * 문제 풀이
 *  세그먼트 트리를 사용해서 구간 곱을 구함.
 *
 * 시간 복잡도: O(n + (m + k) log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11505_구간곱구하기 {
    // public class Main {
    private static int[] arr, seg;
    private static final int MOD = 1_000_000_007;

    private static void init(int n, int s, int e) {
        if (s == e) {
            seg[n] = arr[s];
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            init(l, s, m);
            init(r, m + 1, e);
            seg[n] = (int) ((long) seg[l] * seg[r] % MOD);
        }
    }

    private static void update(int n, int s, int e, int idx, int v) {
        if (s > idx || e < idx) {
            return;
        }

        if (s == e) {
            seg[n] = v;
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            update(l, s, m, idx, v);
            update(r, m + 1, e, idx, v);
            seg[n] = (int) ((long) seg[l] * seg[r] % MOD);
        }
    }

    private static int query(int n, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 1;
        } else if (s >= l && e <= r) {
            return seg[n];
        } else {
            int c = n << 1;
            int m = (s + e) >> 1;

            return (int) ((long) query(c, s, m, l, r) * query(c + 1, m + 1, e, l, r) % MOD);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        arr = new int[n + 1];
        seg = new int[n << 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, n);

        for (int i = m + k; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, n, b, c);
            } else {
                sb.append(query(1, 1, n, b, c)).append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
