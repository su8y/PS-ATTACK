/*
 * 문제: 백준 1108번 - 검색 엔진 (https://www.acmicpc.net/problem/1108)
 * 문제 풀이
 *  타잔 알고리즘을 사용하여 SCC(Strongly Connected Component, 강한 연결 요소)를 찾음.
 *  위상 정렬로 다른 SCC로 향하는 링크만 점수를 더함.
 *
 * 시간 복잡도: O(v + e) - v: 등장한 사이트의 개수, e: 링크의 개수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1108_검색엔진 {
    // public class Main {
    private static int id = 0;
    private static Stack<Site> stack = new Stack<>();

    private static int dfs(Site site) {
        int parent = site.id = ++id;

        stack.push(site);

        for (Site next : site.link) {
            if (next.id == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (next.parent == 0) {
                parent = Math.min(parent, next.id);
            }
        }

        if (parent == site.id) {
            Site child;

            do {
                child = stack.pop();
                child.parent = parent;
            } while (child.id != parent);
        }

        return parent;
    }

    private static class Site {
        int id = 0;
        int parent = 0;
        long score = 1;
        int inDegree = 0;
        List<Site> link = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, Site> sites = new HashMap<>();
        Queue<Site> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Site site = sites.get(name);
            int c = Integer.parseInt(st.nextToken());

            if (site == null) {
                site = new Site();
                sites.put(name, site);
            }

            for (int j = 0; j < c; j++) {
                String subName = st.nextToken();
                Site subSite = sites.get(subName);

                if (subSite == null) {
                    subSite = new Site();
                    sites.put(subName, subSite);
                }

                subSite.link.add(site);
            }
        }

        for (Site site : sites.values()) {
            if (site.parent == 0) {
                dfs(site);
            }
        }

        for (Site site : sites.values()) {
            for (Site next : site.link) {
                if (site.parent != next.parent) {
                    next.inDegree++;
                }
            }
        }

        for (Site site : sites.values()) {
            if (site.inDegree == 0) {
                queue.offer(site);
            }
        }

        while (!queue.isEmpty()) {
            Site site = queue.poll();

            for (Site next : site.link) {
                if (site.parent != next.parent) {
                    next.score += site.score;

                    if (--next.inDegree == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        bw.write(Long.toString(sites.get(br.readLine()).score));
        br.close();
        bw.close();
    }
}
