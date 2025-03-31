/*
 * 문제: 백준 26565번 - Time Limits (https://www.acmicpc.net/problem/26565)
 *
 * 시간 복잡도: O(m * n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_26565_TimeLimits {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int max = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).max().orElse(0);
            int num = max * s;

            num = num / 1000 + (num % 1000 > 0 ? 1 : 0);
            sb.append(num).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
