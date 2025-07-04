/*
 * 문제: 백준 30979번 - 유치원생 파댕이 돌보기 (https://www.acmicpc.net/problem/30979)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_30979_유치원생파댕이돌보기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        bw.write(sum < t ? "Padaeng_i Cry" : "Padaeng_i Happy");
        br.close();
        bw.close();
    }
}
