/*
 * 문제 : 백준 9012번 - 괄호 (https://www.acmicpc.net/problem/9012)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_9012_괄호 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            String result = "YES";

            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }

            if (!stack.isEmpty())
                result = "NO";

            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
