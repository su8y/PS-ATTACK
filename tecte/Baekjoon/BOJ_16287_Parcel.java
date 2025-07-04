/*
 * 문제: 백준 16287번 - Parcel (https://www.acmicpc.net/problem/16287)
 * 문제 풀이
 *  두 수의 합을 미리 저장.
 *  다른 두 수의 합과 목표 무게의 차가 존재하는지 확인.
 *  네 수가 모두 서로 다른 인덱스가 되도록 조건을 조절하여 중복 방지.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16287_Parcel {
    // public class Main {
    private static int w, n;
    private static int[] arr;
    private static boolean[] memo;

    private static boolean solve() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int v = arr[i] + arr[j];

                if (v < w) {
                    memo[v] = true;
                }
            }

            for (int j = i + 2; j < n; j++) {
                int v = arr[i + 1] + arr[j];

                if (v < w && memo[w - v]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        memo = new boolean[w];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solve() ? "YES" : "NO");
        br.close();
        bw.close();
    }
}
