/*
 * 문제: 백준 7490 - 0 만들기 (https://www.acmicpc.net/problem/7490)
 *
 * 시간 복잡도: O(3^n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_7490_0만들기 {
    // public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void dfs(int depth, String operator) throws IOException {
        if (depth == 1) {
            int result = 0;
            int num = 1;
            StringBuilder sb = new StringBuilder("1");

            for (int i = 0; i < operator.length(); i++) {
                char op = operator.charAt(i);

                if (op == ' ') {
                    num *= 10;
                    num += num < 0 ? -i - 2 : i + 2;
                } else {
                    result += num;
                    num = op == '+' ? i + 2 : -i - 2;
                }

                sb.append(op).append(i + 2);
            }

            sb.append("\n");

            if (result + num == 0)
                bw.write(sb.toString());
        } else {
            depth--;
            dfs(depth, operator + " ");
            dfs(depth, operator + "+");
            dfs(depth, operator + "-");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            dfs(Integer.parseInt(br.readLine()), "");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
