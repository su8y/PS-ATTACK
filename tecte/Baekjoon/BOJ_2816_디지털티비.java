/*
 * 문제: 백준 2816번 - 디지털 티비 (https://www.acmicpc.net/problem/2816)
 *
 * 시간 복잡도: O(N)
 */

package Baekjoon;

import java.io.*;

public class BOJ_2816_디지털티비 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] channel = new int[2];
        StringBuilder sb = new StringBuilder();
        StringBuilder sub = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.equals("KBS1") && channel[0] == 0)
                channel[0] = i;
            else if (str.equals("KBS2") && channel[1] == 0)
                channel[1] = i;
        }

        for (int i = 0; i < channel[0]; i++) {
            sb.append(1);
            sub.append(4);
        }

        sb.append(sub);
        sb.append(1);
        sub = new StringBuilder();
        channel[1] += channel[0] > channel[1] ? 1 : 0;

        for (int i = 1; i < channel[1]; i++) {
            sb.append(1);
            sub.append(4);
        }

        bw.write(sb.append(sub).toString());
        br.close();
        bw.close();
    }
}
