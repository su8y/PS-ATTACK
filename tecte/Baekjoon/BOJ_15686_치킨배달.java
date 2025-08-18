/*
 * 문제 : 백준 15686번 - 치킨 배달 (https://www.acmicpc.net/problem/15686)
 * 문제 풀이
 *  백트래킹을 사용하여 최대 치킨집의 개수만큼 재귀호출.
 *  재귀호출할 때마다 유지시킬 치킨집을 선택, 해당 치킨집에서 모든 집들까지의 거리를 구하고 치킨 거리를 갱신.
 *  최대 치킨집의 개수만큼 치킨집을 선택했으면 도시의 치킨 거리를 구하고 비교해서 가장 작은 값을 구함.
 *
 * 시간 복잡도: O(kCm * h * m) - k: 치킨집의 개수, h: 집의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
    // public class Main {
    static int n;
    static int m;
    static List<Pos> houses = new ArrayList<>();
    static List<Pos> chickens = new ArrayList<>();
    static int cityDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());

                if (v == 1)
                    houses.add(new Pos(i, j));
                else if (v == 2)
                    chickens.add(new Pos(i, j));
            }
        }

        int[] dist = new int[houses.size()];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(1, -1, dist);

        bw.write(Integer.toString(cityDist));
        br.close();
        bw.close();
    }

    static void dfs(int depth, int visited, int[] dist) {
        if (depth > m) {
            cityDist = Math.min(cityDist, Arrays.stream(dist).sum());

            return;
        }

        for (int i = visited + 1; i < chickens.size() - m + depth; i++) {
            int[] newDist = new int[dist.length];
            Pos chicken = chickens.get(i);

            for (int j = 0; j < dist.length; j++) {
                Pos house = houses.get(j);

                newDist[j] = Math.min(dist[j], Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }

            dfs(depth + 1, i, newDist);
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
