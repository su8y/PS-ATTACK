/*
 * 문제: 백준 15881번 - Pen Pineapple Apple Pen (https://www.acmicpc.net/problem/15881)
 *
 * 시간 복잡도: O(n)
 */

package baekjoon.workbook1.chapter5.section8;

import java.io.*;

public class BOJ_15881_PenPineappleApplePen {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String ppap = "pPAp";
        int cnt = 0;

        for (int i = 0; i <= n - 4; i++) {
            if (str.substring(i, i + 4).equals(ppap)) {
                cnt++;
                i += 4;
            }
        }

        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}
