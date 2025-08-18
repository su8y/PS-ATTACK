/*
 * 문제 : 백준 6064번 - 카잉 달력 (https://www.acmicpc.net/problem/6064)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int lcm = m * n / gcd(m, n);
            String result = "-1\n";

            for (int year = x; year <= lcm; year += m) {
                if (year % n == y) {
                    result = year + 1 + "\n";
                    break;
                }
            }

            bw.write(result);
        }

        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;

        return gcd(b, a % b);
    }
}
