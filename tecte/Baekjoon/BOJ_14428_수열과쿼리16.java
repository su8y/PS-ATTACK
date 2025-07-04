/*
 * 문제: 백준 14428번 - 수열과 쿼리 16 (https://www.acmicpc.net/problem/14428)
 * 문제 풀이
 *  세그먼트 트리를 사용해서 크기가 가장 작은 값의 인덱스를 구함.
 *
 * 시간 복잡도: O(n + m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14428_수열과쿼리16 {
    // public class Main {
    private static int[] arr, seg;

    private static void init(int n, int s, int e) {
        if (s == e) {
            seg[n] = s;
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            init(l, s, m);
            init(r, m + 1, e);
            seg[n] = arr[seg[l]] > arr[seg[r]] ? seg[r] : seg[l];
        }
    }

    private static void update(int n, int s, int e, int t, int v) {
        if (s > t || e < t) {
            return;
        }

        if (s == e) {
            arr[s] = v;
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            update(l, s, m, t, v);
            update(r, m + 1, e, t, v);
            seg[n] = arr[seg[l]] > arr[seg[r]] ? seg[r] : seg[l];
        }
    }

    private static int query(int n, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 0;
        } else if (s >= l && e <= r) {
            return seg[n];
        }

        int c = n << 1;
        int m = (s + e) >> 1;
        int c1 = query(c, s, m, l, r);
        int c2 = query(c + 1, m + 1, e, l, r);

        return arr[c1] > arr[c2] ? c2 : c1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n + 1];
        seg = new int[n << 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = Integer.MAX_VALUE;
        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == '1') {
                update(1, 1, n, a, b);
            } else {
                sb.append(query(1, 1, n, a, b)).append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
