/*
 * 문제: 백준 2493번 - 탑 (https://www.acmicpc.net/problem/2493)
 * 문제 풀이
 *  스택을 사용하여 뒤에서부터 돌면서 스택에서 현재 탑보다 큰 탑이 나올 때까지 pop.
 *  pop한 탑들이 송신한 신호가 현재 탑으로 수신됨.
 *  pop이 끝나면 현재 탑을 스택에 넣음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_2493_탑 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] top = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (top[stack.peek()] > top[i])
                    break;

                result[stack.pop()] = i + 1;
            }

            stack.add(i);
        }

        for (int r : result)
            bw.write(r + " ");

        br.close();
        bw.close();
    }
}
