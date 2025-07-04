/*
 * 문제: 백준 2110번 - 공유기 설치 (https://www.acmicpc.net/problem/2110)
 * 문제 풀이
 *  이분 탐색으로 공유기를 설치할 거리를 찾고 해당 거리로 설치했을 때 공유기가 몇 개 설치되었는지 확인.
 *  공유기가 c 개보다 적게 설치했으면 거리를 줄이고
 *  c 개 이상 설치했으면 해당 거리를 저장하고 더 큰 거리로 다시 시도.
 *
 * 시간 복잡도: O(n log x)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] houses = new int[n];
        int left = 0;
        int right = 1_000_000_000;
        int result = 0;

        for (int i = 0; i < n; i++)
            houses[i] = Integer.parseInt(br.readLine());

        Arrays.sort(houses);

        while (left <= right) {
            int mid = (left + right) >> 1;
            int last = houses[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (houses[i] - last < mid)
                    continue;

                cnt++;
                last = houses[i];
            }

            if (cnt < c) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
