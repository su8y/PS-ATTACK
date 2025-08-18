/*
 * 문제: 백준 1522번 - 문자열 교환 (https://www.acmicpc.net/problem/1522)
 * 문제 풀이
 *  a를 연속되게 배치해야 하니까 a의 개수만큼 범위를 설정하고 슬라이딩 윈도우를 사용하여 해당 범위 안의 b가 제일 적을 때를 구함.
 *  범위 안의 b의 개수 = 교환 횟수.
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_1522_문자열교환 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str = br.readLine().toCharArray();
        int left = 0;
        int right = 0;
        int cnt = 0;
        int min = 0;

        for (char c : str)
            if (c == 'a' && str[right++] == 'b')
                cnt++;

        if (cnt != 0) {
            min = cnt;

            while (left < str.length - 1) {
                if (str[left] == 'b')
                    cnt--;

                if (str[right] == 'b')
                    cnt++;

                left++;
                right = (right + 1) % str.length;
                min = Math.min(min, cnt);
            }
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }
}
