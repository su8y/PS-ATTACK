/*
 * 문제: 백준 7578번 - 공장 (https://www.acmicpc.net/problem/7578)
 * 문제 풀이
 *  세그먼트 트리 대신 Fenwick Tree(펜윅 트리)를 사용.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7578_공장_2 {
    // public class Main {
    private static int n;
    private static int[] fenwick;

    private static void update(int p) {
        while (p <= n) {
            fenwick[p]++;
            p += p & -p;
        }
    }

    private static int query(int p) {
        int sum = 0;

        while (p > 0) {
            sum += fenwick[p];
            p &= p - 1;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] id = new int[1_000_001];
        int[] arr = new int[n + 1];
        long cnt = 0;

        for (int i = 1; i <= n; i++) {
            id[Integer.parseInt(st.nextToken())] = i;
        }

        st = new StringTokenizer(br.readLine());
        fenwick = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[id[Integer.parseInt(st.nextToken())]] = i;
        }

        for (int i = 1; i <= n; i++) {
            update(arr[i]);
            cnt += query(n) - query(arr[i]);
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
