/*
 * 문제: 백준 28419번 - 더하기 (https://www.acmicpc.net/problem/28419)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_28419_더하기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        long even = 0;
        long odd = 0;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if ((i & 1) == 0) {
                even += arr[i];
            } else {
                odd += arr[i];
            }
        }

        if (n == 3 && even > odd) {
            cnt = -1;
        } else if (even != odd) {
            cnt = even < odd ? odd - even : even - odd;
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
