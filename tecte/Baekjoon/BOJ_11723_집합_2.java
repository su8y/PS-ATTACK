/*
 * 문제: 백준 11723번 - 집합 (https://www.acmicpc.net/problem/11723)
 * 문제 풀이
 *  비트 연산으로 푼 방법
 *
 * 시간 복잡도: O(M)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11723_집합_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int s = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd.charAt(0)) {
                case 'a':
                    if (cmd.charAt(1) == 'd')
                        s |= 1 << (20 - Integer.parseInt(st.nextToken()));
                    else
                        s = (1 << 20) - 1;

                    break;
                case 'r':
                    s &= ~(1 << (20 - Integer.parseInt(st.nextToken())));
                    break;
                case 'c':
                    bw.write((s & (1 << (20 - Integer.parseInt(st.nextToken())))) == 0 ? "0" : "1");
                    bw.newLine();
                    break;
                case 't':
                    s ^= 1 << (20 - Integer.parseInt(st.nextToken()));
                    break;
                case 'e':
                    s = 0;
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
