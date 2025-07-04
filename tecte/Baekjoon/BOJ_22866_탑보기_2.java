/*
 * 문제: 백준 22866번 - 탑 보기 (https://www.acmicpc.net/problem/22866)
 * 문제 풀이
 *  첫 번째 방법에서 이분 탐색 대신 단조 스택(Monotonic Stack)을 사용한 방법.
 *  그런데 제출했을 때 첫 번째 방법이 더 빨랐음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866_탑보기_2 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[n + 1];
        int[] near = new int[n + 1];
        int[] cnt = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        buildings[0] = Integer.MAX_VALUE;
        stack.add(0);

        for (int i = 1; i <= n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());

            while (buildings[stack.peek()] <= buildings[i])
                stack.pop();

            near[i] = stack.peek();
            cnt[i] = stack.size() - 1;
            stack.add(i);
        }

        while (stack.peek() != 0)
            stack.pop();

        for (int i = n; i > 0; i--) {
            while (buildings[stack.peek()] <= buildings[i])
                stack.pop();

            if (near[i] == 0 || (stack.peek() > 0 && i - near[i] > stack.peek() - i))
                near[i] = stack.peek();

            cnt[i] += stack.size() - 1;
            stack.add(i);
        }

        for (int i = 1; i <= n; i++) {
            sb.append(cnt[i]);

            if (cnt[i] != 0)
                sb.append(" ").append(near[i]);

            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
