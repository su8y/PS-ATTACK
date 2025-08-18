/*
 * 문제: 백준 7453번 - 합이 0인 네 정수 (https://www.acmicpc.net/problem/7453)
 * 문제 풀이
 *  n이 최대 4000이므로 4000^4의 조합을 모두 구하기에는 시간 초과가 발생함.
 *  이를 해결하기 위해 중간에서 만나기(Meet in the middle)를 사용.
 *  중간에서 만나기는 한 개의 그룹으로 완전 탐색을 하지 못하는 경우 두 개의 그룹으로 나누어 탐색하고 그 결과를 결합하여 해를 구하는 알고리즘.
 *  네 개의 배열 중 두 배열씩 조합하여 각 조합의 합으로 된 두 개의 새로운 배열을 만듦.
 *  이분 탐색을 통해 두 배열의 합이 0이 되는 개수를 구함.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7453_합이0인네정수 {
    // public class Main {
    private static int[][] arr;
    private static int e;

    private static int lowerBound(int t) {
        int left = 0;
        int right = e;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[1][mid] < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(int t) {
        int left = 0;
        int right = e;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (arr[1][mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[4][n];
        int[][] newArr = new int[2][n * n];
        int s;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
            arr[3][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;

                newArr[0][idx] = arr[0][i] + arr[1][j];
                newArr[1][idx] = arr[2][i] + arr[3][j];
            }
        }

        arr = newArr;
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
        e = arr[0].length;

        for (int i = 0; i < arr[0].length; i++) {
            e = upperBound(-arr[0][i]);
            s = lowerBound(-arr[0][i]);
            cnt += e - s;
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
