/*
 * 문제 : 백준 1167번 - 트리의 지름 (https://www.acmicpc.net/problem/1167)
 * 문제 풀이
 *  dfs로 가장 말단 노드까지 방문. 자신과 형제 노드들의 가중치를 비교해서 가장 무거운 2개의 노드의 합을 지름과 비교
 *  가장 무거운 가중치를 반환. 반환받은 부모 노드는 다시 형제 노드들 중 가장 무거운 2개의 합을 지름과 비교하고 가장 무거운 가중치 반환
 *  루트 노드까지 반복했다면 지름에 있는 값이 트리의 모든 경로 중에서 가장 긴 길이
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
    // public class Main {
    static ArrayList<Node>[] tree;
    static int diameter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            while (c != -1) {
                int w = Integer.parseInt(st.nextToken());

                tree[p].add(new Node(c, w));
                c = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        bw.write(diameter + "");
        br.close();
        bw.close();
    }

    public static int dfs(int v, int visited) {
        int first = 0;
        int second = 0;

        for (Node child : tree[v]) {
            if (child.v == visited)
                continue;

            int w = dfs(child.v, v) + child.w;

            if (first < w) {
                second = first;
                first = w;
            } else {
                second = Math.max(second, w);
            }
        }

        diameter = Math.max(diameter, first + second);

        return first;
    }

    public static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
