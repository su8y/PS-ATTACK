/*
 * 문제: 백준 9935번 - 문자열 폭발 (https://www.acmicpc.net/problem/9935)
 * 문제 풀이
 *  스택에 문자를 하나씩 넣음. 스택에서 폭발 문자열이 만들어지면 폭발 문자열을 꺼내고 그 다음 문자를 하나씩 넣음.
 *
 * 시간 복잡도: O(n * m) - n: 입력받은 문자역의 길이, m: 폭발 문자열의 길이
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ_9935_문자열폭발 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str = br.readLine().toCharArray();
        char[] explosion = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : str) {
            stack.add(c);

            if (stack.size() >= explosion.length) {
                boolean isExplosion = true;

                for (int i = 1; i <= explosion.length; i++) {
                    if (stack.get(stack.size() - i) != explosion[explosion.length - i]) {
                        isExplosion = false;
                        break;
                    }
                }

                if (isExplosion)
                    for (int i = 0; i < explosion.length; i++)
                        stack.pop();
            }
        }

        if (stack.isEmpty())
            bw.write("FRULA");
        else
            bw.write(stack.stream().map(String::valueOf).collect(Collectors.joining()));

        br.close();
        bw.close();
    }
}
