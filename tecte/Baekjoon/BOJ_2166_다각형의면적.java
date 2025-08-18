/*
 * 문제: 백준 2166번 - 다각형의 면적 (https://www.acmicpc.net/problem/2166)
 * 문제 풀이
 *  신발끈 공식을 사용해서 다각형의 넓이를 계산.
 *  신발끈 공식은 다각형의 모든 꼭짓점을 시계방향 또는 반시계방향으로 나열.
 *  각 꼭짓점의 x와 다음 꼭짓점의 y를 곱한 값들을 모두 더함.
 *  각 꼭짓점의 y와 다음 꼭짓점의 x를 곱한 값들을 모두 더함.
 *  두 합의 차를 구한 뒤 절대값을 취하고, 2로 나누면 다각형의 넓이를 구할 수 있음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {
    // public class Main {
    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Pos> list = new ArrayList<>(n + 1);
        long a = 0;
        long b = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pos(x, y));
        }

        list.add(list.get(0));

        for (int i = 0; i < n; i++) {
            a += (long) list.get(i).x * list.get(i + 1).y;
            b += (long) list.get(i).y * list.get(i + 1).x;
        }

        bw.write(String.format("%.1f", (Math.abs(a - b) / 2.0)));
        br.close();
        bw.close();
    }
}
