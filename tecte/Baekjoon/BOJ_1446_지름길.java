/*
 * 문제: 백준 1446번 - 지름길 (https://www.acmicpc.net/problem/1446)
 * 문제 풀이
 *  DP로 푼 방법.
 *
 * 시간 복잡도: O(d)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
    // public class Main {
    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Edge>[] shortcut = new List[d + 1];
        int[] dist = new int[10001];

        for (int i = 0; i < shortcut.length; i++)
            shortcut[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            shortcut[s].add(new Edge(e, w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        if (shortcut[0] != null)
            for (Edge edge : shortcut[0])
                dist[edge.to] = Math.min(dist[edge.to], edge.w);

        for (int i = 1; i <= d; i++) {
            dist[i] = Math.min(dist[i], dist[i - 1] + 1);

            if (shortcut[i] == null)
                continue;

            for (Edge edge : shortcut[i])
                dist[edge.to] = Math.min(dist[edge.to], dist[i] + edge.w);
        }

        bw.write(Integer.toString(dist[d]));
        br.close();
        bw.close();
    }
}
