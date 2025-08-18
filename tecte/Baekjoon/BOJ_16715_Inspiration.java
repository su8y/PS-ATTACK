/*
 * 문제: 백준 16715번 - Inspiration (https://www.acmicpc.net/problem/16715)
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_16715_Inspiration {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        int max = 0;

        for (int i = 2; i <= n; i++) {
            int q = n;
            int sum = 0;

            while (q > 0) {
                sum += q % i;
                q /= i;
            }

            if (sum > max) {
                num = i;
                max = sum;
            }
        }

        bw.write(max + " " + num);
        br.close();
        bw.close();
    }
}
