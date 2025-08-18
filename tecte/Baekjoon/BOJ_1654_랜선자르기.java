/*
 * 문제 : 백준 1654번 - 랜선 자르기 (https://www.acmicpc.net/problem/1654)
 * 문제 풀이
 *  1부터 k개의 랜선 중에 가장 긴 랜선의 길이까지 탐색 범위로 해서 매개 변수 탐색을 함
 *  왜 가장 긴 랜선의 길이까지면, 만들 수 있는 랜선의 최대 길이가 주어진 랜선의 길이보다 길 수도 있기 때문
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lan = new int[k];
        long max = 0;
        long min = 1;
        long result = 0;

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }

        while (min <= max) {
            long mid = (max + min) / 2;
            long cnt = 0;

            for (int l : lan)
                cnt += l / mid;

            if (cnt < n) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }

        bw.write(result + "");
        br.close();
        bw.close();
    }
}
