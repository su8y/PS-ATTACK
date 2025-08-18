/*
 * 문제 : 백준 4949번 - 균형잡힌 세상 (https://www.acmicpc.net/problem/4949)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            String result = "yes";

            if (input.equals("."))
                break;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        result = "no";
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        result = "no";
                        break;
                    }
                }
            }

            if (!stack.isEmpty())
                result = "no";

            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
