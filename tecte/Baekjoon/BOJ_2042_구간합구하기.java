/*
 * 문제: 백준 2042번 - 구간 합 구하기 (https://www.acmicpc.net/problem/2042)
 * 문제 풀이
 *  세그먼트 트리를 사용해서 구간 합을 구함.
 *
 * 시간 복잡도: O(n + (m + k) log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2042_구간합구하기 {
    // public class Main {
    private static long[] seg;

    private static void init(long[] arr, int node, int start, int end) {
        if (start == end) {
            seg[node] = arr[start];
        } else {
            int left = node << 1;
            int right = left + 1;
            int mid = (start + end) >> 1;

            init(arr, left, start, mid);
            init(arr, right, mid + 1, end);
            seg[node] = seg[left] + seg[right];
        }
    }

    private static void update(int node, int start, int end, int idx, long val) {
        if (start <= idx && idx <= end) {
            if (start == end) {
                seg[node] = val;
            } else {
                int left = node << 1;
                int right = left + 1;
                int mid = (start + end) >> 1;

                update(left, start, mid, idx, val);
                update(right, mid + 1, end, idx, val);
                seg[node] = seg[left] + seg[right];
            }
        }
    }

    private static long query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return seg[node];
        }

        int child = node << 1;
        int mid = (start + end) >> 1;

        return query(child, start, mid, left, right) + query(child + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        seg = new long[n << 2];
        init(arr, 1, 0, --n);

        for (int i = m + k; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 0, n, b - 1, c);
            } else {
                sb.append(query(1, 0, n, b - 1, (int) c - 1)).append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
