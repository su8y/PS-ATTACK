/*
 * 문제: 백준 7578번 - 공장 (https://www.acmicpc.net/problem/7578)
 * 문제 풀이
 *  A열의 각 식별번호가 B열에서 어느 위치에 등장하는지를 기록하고, B열의 해당 위치 뒤에 이미 등장한 식별번호가 있는지 확인.
 *  이미 등장한 식별번호의 개수만큼 케이블 쌍의 개수를 증가.
 *  등장한 식별번호를 기록하거나, 뒤에 있는 등장 개수를 확인할 때 세그먼트 트리를 사용.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7578_공장_1 {
    // public class Main {
    private static int[] seg;

    private static void update(int n, int s, int e, int i) {
        if (s <= i && i <= e) {
            if (s == e) {
                seg[n] = 1;
            } else {
                int l = n << 1;
                int r = l + 1;
                int m = (s + e) >> 1;

                update(l, s, m, i);
                update(r, m + 1, e, i);
                seg[n] = seg[l] + seg[r];
            }
        }
    }

    private static int query(int n, int s, int e, int l, int r) {
        if (l > e || r < s) {
            return 0;
        } else if (l <= s && e <= r) {
            return seg[n];
        }

        int c = n << 1;
        int m = (s + e) >> 1;

        return query(c, s, m, l, r) + query(c + 1, m + 1, e, l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] id = new int[1_000_001];
        int[] arr = new int[n];
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            id[Integer.parseInt(st.nextToken())] = i;
        }

        st = new StringTokenizer(br.readLine());
        seg = new int[n << 2];

        for (int i = 0; i < n; i++) {
            arr[id[Integer.parseInt(st.nextToken())]] = i;
        }

        for (int i = 0; i < n; i++) {
            update(1, 0, n, arr[i]);
            cnt += query(1, 0, n, arr[i] + 1, n);
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
