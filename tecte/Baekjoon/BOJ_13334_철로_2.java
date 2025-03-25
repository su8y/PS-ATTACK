/*
 * 문제: 백준 13334번 - 철로 (https://www.acmicpc.net/problem/13334)
 * 문제 풀이
 *  스위핑 알고리즘을 사용해 선분을 종료점 기준으로 정렬하고, 우선순위 큐를 활용하여 범위 내에서 겹치는 최대 선분 개수를 구함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13334_철로_2 {
    // public class Main {
    private static class Line {
        int s, e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Line[] line = new Line[n];
        PriorityQueue<Line> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.s));
        int d, max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());

            line[i] = h < o ? new Line(h, o) : new Line(o, h);
        }

        Arrays.sort(line, Comparator.comparingInt(a -> a.e));
        d = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long start = line[i].e - d;

            pq.offer(line[i]);

            while (!pq.isEmpty() && pq.peek().s < start) {
                pq.poll();
            }

            max = Math.max(max, pq.size());
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
