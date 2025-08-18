/*
 * 문제: 코드포스 - A. Which is up? (https://codeforces.com/gym/105416/problem/A)
 */

package Codeforces;

import java.io.*;

public class CF_105416_A_WhichIsUp {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int prev = 1;

        for (int i = 1; i < n; i++) {
            int state = (4 * prev ^ i) % 6;

            if (state == 1)
                cnt++;

            prev = state;
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
