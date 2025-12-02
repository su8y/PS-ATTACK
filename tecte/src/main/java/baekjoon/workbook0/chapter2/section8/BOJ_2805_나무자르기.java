/*
 * 문제: 백준 2805번 - 나무 자르기 (https://www.acmicpc.net/problem/2805)
 *
 * 시간 복잡도: O(n * log h) - h: 절단기의 높이
 */

package baekjoon.workbook0.chapter2.section8;

import java.io.*;
import java.util.*;

public class BOJ_2805_나무자르기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        int low = 1;
        int high = 0;
        int cut = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, trees[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            long get = 0;

            for (int tree : trees)
                if (mid < tree)
                    get += tree - mid;

            if (get < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
                cut = mid;
            }
        }

        bw.write(cut + "");
        br.close();
        bw.close();
    }
}
