/*
 * 문제: 백준 2357번 - 최솟값과 최댓값 (https://www.acmicpc.net/problem/2357)
 * 문제 풀이
 *  세그먼트 트리를 사용해서 구간의 최솟값과 최댓값을 구함.
 *
 * 시간 복잡도: O(n + m log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2357_최솟값과최댓값 {
    // public class Main {
    private static int[] arr;
    private static Node[] seg;

    private static void init(int n, int s, int e) {
        if (s == e) {
            seg[n] = new Node(arr[s], arr[e]);
        } else {
            int l = n << 1;
            int r = l + 1;
            int m = (s + e) >> 1;

            init(l, s, m);
            init(r, m + 1, e);
            seg[n] = new Node(Math.min(seg[l].min, seg[r].min), Math.max(seg[l].max, seg[r].max));
        }
    }

    private static Node query(int n, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return new Node(Integer.MAX_VALUE, 0);
        } else if (s >= l && e <= r) {
            return seg[n];
        } else {
            int c = n << 1;
            int m = (s + e) >> 1;
            Node c1 = query(c, s, m, l, r);
            Node c2 = query(c + 1, m + 1, e, l, r);

            return new Node(Math.min(c1.min, c2.min), Math.max(c1.max, c2.max));
        }
    }

    private static class Node {
        int min, max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        arr = new int[n + 1];
        seg = new Node[n << 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node node = query(1, 1, n, a, b);

            sb.append(node.min).append(" ").append(node.max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
