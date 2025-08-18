/*
 * 문제: 백준 27172번 - 수 나누기 게임 (https://www.acmicpc.net/problem/27172)
 * 문제 풀이
 *  배수 관계를 이용하여 각 수의 배수를 구하여 배수인 수가 있으면 배수는 점수를 잃고 약수는 점수를 얻음.
 *
 * 시간 복잡도: O(n log m) - m: 카드의 최대 수
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_27172_수나누기게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] nums = new boolean[1_000_001];
        int max = 0;
        int[] score = new int[1_000_001];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums[arr[i]] = true;
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 2; arr[i] * j <= max; j++) {
                if (nums[arr[i] * j]) {
                    score[arr[i]]++;
                    score[arr[i] * j]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(score[arr[i]]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
