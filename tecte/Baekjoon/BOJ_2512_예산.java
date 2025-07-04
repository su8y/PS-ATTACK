/*
 * 문제: 백준 2512번 - 예산 (https://www.acmicpc.net/problem/2512)
 * 문제 풀이
 *  매개 변수 탐색으로 상한액을 찾음.
 *
 * 시간 복잡도: O(N log M)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int budget = Integer.parseInt(br.readLine());
        int[] region = new int[n];
        int max = 0;
        int low = 0;
        int high = budget;
        int limit = 0;

        for (int i = 0; i < n; i++) {
            region[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, region[i]);
        }

        while (low <= high) {
            int mid = (low + high) >> 1;
            int sum = 0;

            for (int r : region)
                sum += Math.min(r, mid);

            if (sum > budget) {
                high = mid - 1;
            } else {
                low = mid + 1;
                limit = mid;
            }
        }

        bw.write(Integer.toString(Math.min(max, limit)));
        br.close();
        bw.close();
    }
}
