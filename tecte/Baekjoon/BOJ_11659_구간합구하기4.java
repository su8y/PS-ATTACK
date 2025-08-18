/*
 * 문제 : 백준 11659번 - 구간 합 구하기 4 (https://www.acmicpc.net/problem/11659)
 * 문제풀이
 *  배열에 인덱스까지의 합을 저장하고 A~B의 구간 합을 구할 때는 B까지 누적 합에 A 전까지의 누적 합을 뺌
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
            sequence[i] = Integer.parseInt(st.nextToken()) + sequence[i - 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(sequence[b] - sequence[a - 1] + "");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
