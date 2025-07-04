/*
 * 문제: 백준 2531번 - 회전 초밥 (https://www.acmicpc.net/problem/2531)
 * 문제 풀이
 *  k개의 초밥을 슬라이딩 윈도우에 넣어 초밥의 개수를 세고 쿠폰 초밥을 추가해서 먹을 수 있는 초밥의 종류를 셈.
 *  슬라이딩 윈도우를 배열의 끝까지 한 칸씩 이동하며 초밥을 추가하고 제거함.
 *  이동할 때마다 현재 초밥 종류와 최대값을 비교해서 갱신.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] dish = new int[n];
        int[] sushi = new int[d + 1];
        int cnt = ++sushi[c];

        for (int i = 0; i < n; i++) {
            dish[i] = Integer.parseInt(br.readLine());

            if (i < k && sushi[dish[i]]++ == 0)
                cnt++;
        }

        int max = cnt;
        int left = 0;
        int right = k;

        while (left < n) {
            if (sushi[dish[right]]++ == 0)
                cnt++;

            if (--sushi[dish[left]] == 0)
                cnt--;

            max = Math.max(max, cnt);
            right = (right + 1) % n;
            left++;
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
