/*
 * 문제: 백준 16951번 - 블록 놀이 (https://www.acmicpc.net/problem/16951)
 * 문제 풀이
 *  각 탑을 기준으로 선택하고 해당 탑을 기준으로 왼쪽과 오른쪽의 탑들을 높이를 확인해서 모든 탑의 높이 차를 k로 만드는 최소 시간을 구함.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16951_블록놀이 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i * k >= tops[i])
                continue;

            int[] arr = tops.clone();
            int time = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] + k != arr[j + 1])
                    time++;

                arr[j] = arr[j + 1] - k;
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j - 1] + k != arr[j])
                    time++;

                arr[j] = arr[j - 1] + k;
            }

            min = Math.min(min, time);
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }
}
