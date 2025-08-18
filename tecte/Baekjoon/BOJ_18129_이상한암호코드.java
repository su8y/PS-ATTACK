/*
 * 문제: 백준 18129번 - 이상한 암호코드 (https://www.acmicpc.net/problem/18129)
 *
 * 시간 복잡도: O(n) - n: 문자열의 길이
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18129_이상한암호코드 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder s = new StringBuilder(st.nextToken().toLowerCase()).append((char) ('z' + 1));
        int k = Integer.parseInt(st.nextToken());
        boolean[] alphabet = new boolean[27];
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else if (!alphabet[s.charAt(i - 1) - 'a']) {
                sb.append(cnt < k ? 0 : 1);
                cnt = 1;
                alphabet[s.charAt(i - 1) - 'a'] = true;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
