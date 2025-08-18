/*
 * 문제: 백준 2162번 - 선분 그룹 (https://www.acmicpc.net/problem/2162)
 * 문제 풀이
 *  모든 선분 쌍을 비교하며 CCW를 사용하며 두 선분이 교차하는지 판단.
 *  두 선분이 교차하면 Union-Find를 사용하여 그룹 관리.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2162_선분그룹 {
    // public class Main {
    private static Pos[][] lines;
    private static int[] parents;
    private static final Map<Integer, Integer> map = new HashMap<>();

    private static int ccw(Pos a, Pos b, Pos c) {
        Pos ab = new Pos(b.x - a.x, b.y - a.y);
        Pos ac = new Pos(c.x - a.x, c.y - a.y);
        int cross = ab.x * ac.y - ac.x * ab.y;

        return Integer.compare(cross, 0);
    }

    private static boolean isCross(int a, int b) {
        int cross1 = ccw(lines[a][0], lines[a][1], lines[b][0]) * ccw(lines[a][0], lines[a][1], lines[b][1]);
        int cross2 = ccw(lines[b][0], lines[b][1], lines[a][0]) * ccw(lines[b][0], lines[b][1], lines[a][1]);

        return (cross1 + cross2 < 0 || (cross1 == 0 && cross2 == 0 &&
                Math.min(lines[a][0].x, lines[a][1].x) <= Math.max(lines[b][0].x, lines[b][1].x) &&
                Math.max(lines[a][0].x, lines[a][1].x) >= Math.min(lines[b][0].x, lines[b][1].x) &&
                Math.min(lines[a][0].y, lines[a][1].y) <= Math.max(lines[b][0].y, lines[b][1].y) &&
                Math.max(lines[a][0].y, lines[a][1].y) >= Math.min(lines[b][0].y, lines[b][1].y)));
    }

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB && isCross(a, b)) {
            if (rootA > rootB) {
                parents[rootA] = rootB;
                map.put(rootB, map.get(rootA) + map.get(rootB));
                map.remove(rootA);
            } else {
                parents[rootB] = rootA;
                map.put(rootA, map.get(rootA) + map.get(rootB));
                map.remove(rootB);
            }
        }
    }

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
        StringBuilder sb = new StringBuilder();

        lines = new Pos[n][2];
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                lines[i][j] = new Pos(x, y);
            }
        }

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            map.put(i, 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                union(i, j);
            }
        }

        sb.append(map.size()).append("\n").append(Collections.max(map.values()));
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
