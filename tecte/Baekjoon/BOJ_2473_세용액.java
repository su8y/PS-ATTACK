/*
 * 문제: 백준 2473번 - 세 용액 (https://www.acmicpc.net/problem/2473)
 * 문제 풀이
 *  용액을 오름차순으로 정렬한 다음, 두 개의 용액을 고정하고 나머지 하나의 용액은 이진 탐색으로 찾음.
 *
 * 시간 복잡도: O(n^2 log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2473_세용액 {
    // public class Main {
    private static int n;
    private static int[] solutions;
    private static int[] mixture = new int[3];

    private static void mix() {
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                int left = i + 1;
                int right = j - 1;

                while (left <= right) {
                    int mid = (left + right) >> 1;
                    long num = (long) solutions[i] + solutions[j] + solutions[mid];

                    if (Math.abs(num) < min) {
                        min = Math.abs(num);
                        mixture[0] = solutions[i];
                        mixture[1] = solutions[mid];
                        mixture[2] = solutions[j];
                    }

                    if (num == 0) {
                        return;
                    } else if (num < 0) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(solutions);
        mix();
        bw.write(sb.append(mixture[0]).append(" ").append(mixture[1]).append(" ").append(mixture[2]).toString());
        br.close();
        bw.close();
    }
}
