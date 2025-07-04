/*
 * 문제: 백준 3015번 - 오아시스 재결합 (https://www.acmicpc.net/problem/3015)
 * 문제 풀이
 *  스택을 사용해 이전에 등장한 사람들의 키를 저장하며, 같은 키의 등장 개수도 저장.
 *  현재 사람의 키가 스택 top보다 크면, 작거나 같을 때까지 pop하고 그때마다 쌍의 수를 1씩 증가
 *  현재 사람의 키가 스택 top보다 작으면 쌍의 수를 1 증가.
 *  같은 키라면, 해당 키가 스택에 있는만큼 쌍의 수를 증가.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3015_오아시스재결합 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> height = new HashMap<>();
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() < h) {
                int num = stack.pop();

                height.put(num, height.get(num) - 1);
                cnt++;
            }

            if (!stack.isEmpty()) {
                if (stack.peek() > h) {
                    cnt++;
                } else {
                    cnt += stack.size() == height.get(h) ? stack.size() : height.get(h) + 1;
                }
            }

            stack.add(h);
            height.put(h, height.getOrDefault(h, 0) + 1);
        }

        bw.write(Long.toString(cnt));
        br.close();
        bw.close();
    }
}
