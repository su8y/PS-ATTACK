/*
 * 문제: 백준 3653번 - 영화 수집 (https://www.acmicpc.net/problem/3653)
 * 문제 풀이
 *  배열에 DVD의 위치를 저장하는 대신, DVD가 언제 위쪽으로 이동했는지를 저장.
 *  세그먼트 트리를 이용하여 특정 DVD 위쪽에 있는 DVD의 개수를 구함.
 *  DVD를 꺼낼 때마다 세그먼트 트리를 업데이트하여 이전 위치를 제거하고 새 위치에 추가함.
 *
 * 시간 복잡도: O(t * m log (n + m)) - t: 테스트 케이스의 개수
 */

package baekjoon.workbook0.chapter3.section6;

import java.io.*;
import java.util.*;

public class BOJ_3653_영화수집 {
    // public class Main {
    private static int update(int[] seg, int n, int s, int e, int k, int v) {
        if (k < s || k > e) {
            return seg[n];
        } else if (s == e) {
            return seg[n] = v;
        }

        int c = n * 2;
        int m = (s + e) / 2;

        return seg[n] = update(seg, c, s, m, k, v) + update(seg, c + 1, m + 1, e, k, v);
    }

    private static int query(int[] seg, int n, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 0;
        } else if (l <= s && e <= r) {
            return seg[n];
        }

        int c = n * 2;
        int m = (s + e) / 2;

        return query(seg, c, s, m, l, r) + query(seg, c + 1, m + 1, e, l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = n + m;
            int[] dvds = new int[n + 1];
            int[] seg = new int[l * 4];

            for (int i = 1; i <= n; i++) {
                dvds[n - i + 1] = i;
                update(seg, 1, 1, l, i, 1);
            }

            st = new StringTokenizer(br.readLine());

            for (int i = n + 1; i <= l; i++) {
                int dvd = Integer.parseInt(st.nextToken());

                sb.append(query(seg, 1, 1, l, dvds[dvd] + 1, l)).append(" ");
                update(seg, 1, 1, l, dvds[dvd], 0);
                update(seg, 1, 1, l, i, 1);
                dvds[dvd] = i;
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
