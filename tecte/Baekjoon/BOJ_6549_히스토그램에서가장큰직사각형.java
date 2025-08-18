/*
 * 문제: 백준 6549번 - 히스토그램에서 가장 큰 직사각형 (https://www.acmicpc.net/problem/6549)
 * 문제 풀이
 *  스택을 이용하여 직사각형의 높이와 위치를 저장.
 *  현재 높이가 이전보다 작아지는 지점을 만나면, 스택에서 꺼내며 해당 높이로 만들 수 있는 가장 넓은 직사각형의 넓이를 계산.
 *  반복이 끝난 후에도 스택에 남아 있는 직사각형들에 대해 동일한 방식으로 넓이를 계산해서 최대 넓이를 구함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_6549_히스토그램에서가장큰직사각형 {
    // public class Main {
    private static class Bar {
        long h;
        int pos;

        public Bar(long h, int pos) {
            this.h = h;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            Stack<Bar> stack = new Stack<>();
            long area = 0;

            for (int i = 0; i < n; i++) {
                int h = Integer.parseInt(st.nextToken());
                int p = i;

                while (!stack.isEmpty() && stack.peek().h > h) {
                    Bar bar = stack.pop();

                    p = bar.pos;
                    area = Math.max(area, (i - bar.pos) * bar.h);
                }

                if (stack.isEmpty() || stack.peek().h < h) {
                    stack.add(new Bar(h, p));
                }
            }

            while (!stack.isEmpty()) {
                Bar bar = stack.pop();

                area = Math.max(area, (n - bar.pos) * bar.h);
            }

            sb.append(area).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
