/*
 * 문제: 백준 32289번 - Max-Queen (https://www.acmicpc.net/problem/32289)
 * 문제 풀이
 *  모든 칸에 퀸을 놓고 공격 가능한 쌍을 세면 공격하는 쌍의 최대 개수를 구할 수 있음.
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_32289_MaxQueen {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()) - 2;
        long m = Long.parseLong(st.nextToken()) - 2;
        long cnt = n * m * 8 + (n + m) * 10 + 12;

        bw.write(Long.toString(cnt >> 1));
        br.close();
        bw.close();
    }
}
