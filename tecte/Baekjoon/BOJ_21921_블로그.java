/*
 * 문제: 백준 21921번 - 블로그 (https://www.acmicpc.net/problem/21921)
 * 문제 풀이
 *  N일차 + N-1일차를 해서 누적 합을 구하고 누적 N일차 - 누적 N-X를 해서 원하는 구간의 누적 합을 구함.
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] day = new int[n + 1];
        int visit = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            day[i] = day[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = x, j = 0; i <= n; i++, j++) {
            int sum = day[i] - day[j];

            if (visit < sum) {
                visit = sum;
                cnt = 1;
            } else if (visit == sum) {
                cnt++;
            }
        }

        if (visit == 0) {
            bw.write("SAD");
        } else {
            bw.write(Integer.toString(visit));
            bw.newLine();
            bw.write(Integer.toString(cnt));
        }

        br.close();
        bw.close();
    }
}
