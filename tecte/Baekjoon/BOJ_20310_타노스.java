/*
 * 문제: 백준 20310번 - 타노스 (https://www.acmicpc.net/problem/20310)
 * 문제 풀이
 *  0과 1의 개수를 세고 문자열을 돌면서 처음에 나오는 절반의 1과 나중에 나오는 절반의 0을 지움.
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_20310_타노스 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int cnt0 = 0;
        int cnt1 = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '0')
                cnt0++;
            else
                cnt1++;
        }

        cnt0 >>= 1;
        cnt1 >>= 1;

        for (char c : str.toCharArray()) {
            if (c == '0') {
                if (cnt0 > 0) {
                    cnt0--;
                    sb.append(0);
                }
            } else {
                if (cnt1 > 0)
                    cnt1--;
                else
                    sb.append(1);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
