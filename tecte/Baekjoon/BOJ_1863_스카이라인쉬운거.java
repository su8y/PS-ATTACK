/*
 * 문제: 백준 1863번 - 스카이라인 쉬운거 (https://www.acmicpc.net/problem/1863)
 * 문제 풀이
 *  스카이라인의 고도가 바뀔 때마다 스택에 현재 고도보다 큰 고도가 있으면 pop을 하고 개수를 +1함.
 *  이 후 스택의 top이 현재 고도 보다 작으면 현재 고도를 스택에 넣음.
 *  위 과정을 n 번하고 개수에 스택의 사이즈를 더하면 최소 건물 개수를 알 수 있음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;

public class BOJ_1863_스카이라인쉬운거 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cnt = -1;

        stack.add(0);

        while (n-- > 0) {
            int y = Integer.parseInt(br.readLine().split(" ")[1]);

            while (stack.peek() > y) {
                stack.pop();
                cnt++;
            }

            if (stack.peek() < y)
                stack.add(y);
        }

        bw.write(Integer.toString(cnt + stack.size()));
        br.close();
        bw.close();
    }
}
