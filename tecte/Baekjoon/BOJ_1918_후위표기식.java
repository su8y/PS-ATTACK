/*
 * 문제 : 백준 1918번 - 후위 표기식 (https://www.acmicpc.net/problem/1918)
 * 문제 풀이
 *  피연산자는 바로 출력하고 연산자는 스택에 넣음
 *  스택에 넣을 때 (는 스택에 바로 넣고 )는 (가 나올 때까지 스택에서 pop 해서 출력
 *  +,-,*,/는 현재 연산자가 스택의 top에 있는 연산자보다 우선순위가 크거나 (가 나올 때까지 pop 하고 현재 연산자를 스택에 넣음
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String formula = "(" + br.readLine() + ")";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : formula.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            } else if (c == '+' || c == '-') {
                while (stack.peek() != '(')
                    sb.append(stack.pop());
            } else if (c == '*' || c == '/') {
                if (stack.peek() == '*' || stack.peek() == '/')
                    sb.append(stack.pop());
            } else if (c == ')') {
                while (stack.peek() != '(')
                    sb.append(stack.pop());

                stack.pop();
                continue;
            }

            stack.add(c);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
