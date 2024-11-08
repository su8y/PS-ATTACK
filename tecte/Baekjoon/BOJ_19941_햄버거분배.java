/*
 * 문제: 백준 19941번 - 햄버거 분배 (https://www.acmicpc.net/problem/19941)
 * 문제 풀이
 *  i번째 위치에 사람이 있으면 i+k 범위 안에 햄버거가 있는지 확인하고
 *  i번째 위치에 햄버거가 있으면 i+k 범위 안에 사람이 있는지 확인.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거분배 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] table = br.readLine().toCharArray();
        int left = 0;
        int right = 0;
        int cnt = 0;

        while (left < n && right < n) {
            if (table[left] != 0) {
                while (right <= left + k && right < n) {
                    if ((table[left] == 'H' && table[right] == 'P') || (table[left] == 'P' && table[right] == 'H')) {
                        cnt++;
                        table[right] = 0;
                        break;
                    }

                    right++;
                }
            }

            left++;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
