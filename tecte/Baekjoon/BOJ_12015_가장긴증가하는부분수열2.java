/*
 * 문제: 백준 12015번 - 가장 긴 증가하는 부분 수열 2 (https://www.acmicpc.net/problem/12015)
 * 문제 풀이
 *  현재 숫자가 수열의 마지막보다 크면 추가하고 작으면 이진 탐색을 통해 해당 숫자가 들어갈 위치를 찾아 대체하며 최대 길이를 구함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_12015_가장긴증가하는부분수열2 {
    // public class Main {
    private static int[] arr;
    private static int pos = 0;

    private static int lowerBound(int target) {
        int left = 1;
        int right = pos;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > arr[pos]) {
                arr[++pos] = num;
            } else if (num < arr[pos]) {
                arr[lowerBound(num)] = num;
            }
        }

        bw.write(Integer.toString(pos));
        br.close();
        bw.close();
    }
}
