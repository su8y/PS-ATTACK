/*
 * 문제: 백준 14725번 - 개미굴 (https://www.acmicpc.net/problem/14725)
 * 문제 풀이
 *  TreeMap을 사용하여 트리 구조를 저장하고 DFS를 사용하여 계층 구조를 정렬된 형태로 출력.
 *
 * 시간 복잡도: O(n * k)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14725_개미굴 {
    // public class Main {
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int depth, Cave cave) {
        StringBuilder lv = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            lv.append("--");
        }

        for (Map.Entry<String, Cave> entry : cave.map.entrySet()) {
            sb.append(lv).append(entry.getKey()).append("\n");
            dfs(depth + 1, entry.getValue());
        }
    }

    private static class Cave {
        Map<String, Cave> map = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Cave root = new Cave();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Cave cave = root;

            for (int j = 0; j < k; j++) {
                String food = st.nextToken();

                if (!cave.map.containsKey(food)) {
                    cave.map.put(food, new Cave());
                }

                cave = cave.map.get(food);
            }
        }

        dfs(0, root);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
