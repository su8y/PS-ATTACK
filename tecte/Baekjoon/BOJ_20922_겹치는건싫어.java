/*
 * 문제: 백준 20922번 - 겹치는 건 싫어 (https://www.acmicpc.net/problem/20922)
 * 문제 풀이
 *  투 포인터를 사용하여 최장 연속 부분 수열을 구함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[100001];
        int left = 0;
        int right = 0;
        int len = 0;

        while (right < n) {
            if (cnt[sequence[right]] < k) {
                cnt[sequence[right]]++;
                right++;
                len = Math.max(len, right - left);
            } else {
                cnt[sequence[left]]--;
                left++;
            }
        }

        bw.write(Integer.toString(len));
        br.close();
        bw.close();
    }
}
