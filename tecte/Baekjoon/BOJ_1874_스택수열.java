/*
 * 문제 : 백준 1874번 - 스택 수열 (https://www.acmicpc.net/problem/1874)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_1874_스택수열 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                for (int j = max + 1; j <= num; j++) {
                    stack.push(j);
                    result.append("+\n");
                }

                max = num;
            } else if (stack.peek() != num) {
                result = new StringBuilder("NO");

                break;
            }

            stack.pop();
            result.append("-\n");
        }

        bw.write(result.toString());
        br.close();
        bw.close();
    }
}
