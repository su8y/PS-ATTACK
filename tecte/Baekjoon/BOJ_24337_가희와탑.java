/*
 * 문제: 24337번 - 가희와 탑 (https://www.acmicpc.net/problem/24337)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24337_가희와탑 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int height = Math.max(a, b);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if (a + b > n + 1) {
            sb.append(-1);
        } else {
            for (int i = 0; i <= n - a - b; i++)
                sb2.append("1 ");

            for (int i = 1; i < a; i++)
                sb.append(i).append(" ");

            if (a > 1)
                sb = sb2.append(sb).append(height).append(" ");
            else
                sb.append(height).append(" ").append(sb2);

            for (int i = b - 1; i > 0; i--)
                sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
