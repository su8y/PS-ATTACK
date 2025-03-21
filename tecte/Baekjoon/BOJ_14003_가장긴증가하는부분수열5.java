/*
 * 문제: 백준 14003번 - 가장 긴 증가하는 부분 수열 5 (https://www.acmicpc.net/problem/14003)
 * 문제 풀이
 *  LIS를 사용하여 가장 긴 증가하는 부분 수열의 길이를 구하고 역추적하여 실제 LIS를 복원.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14003_가장긴증가하는부분수열5 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        List<Integer> lis = new ArrayList<>();
        int pos;
        int[] backtrack = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos = Collections.binarySearch(lis, arr[i]);
            pos = pos < 0 ? -pos - 1 : pos;
            backtrack[i] = pos;

            if (pos < lis.size()) {
                lis.set(pos, arr[i]);
            } else {
                lis.add(arr[i]);
            }
        }

        pos = lis.size();
        sb.append(pos--).append("\n");

        for (int i = n - 1; i >= 0; i--) {
            if (backtrack[i] == pos) {
                lis.set(pos--, arr[i]);
            }
        }

        for (int num : lis) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
