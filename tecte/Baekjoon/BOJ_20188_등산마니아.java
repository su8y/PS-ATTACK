/*
 * 문제: 백준 20188번 - 등산 마니아 (https://www.acmicpc.net/problem/20188)
 * 문제 풀이
 *  DFS로 탐색하면서 각 노드를 루트로 하는 서브트리의 정보를 받아 거리의 합을 구함.
 *  각 노드들은 자신을 루트로 했을 때 서브트리의 노드 개수와 현재 노드에서 모든 자식 노드까지의 합을 반환.
 *  각 노드들을 방문할 때마다 (서브트리 크기 x 깊이 + 현재 노드에서 모든 자식 노드까지의 합)을 계산에서 누적 합을 구함.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20188_등산마니아 {
    // public class Main {
    private static List<List<Integer>> path = new ArrayList<>();
    private static long total = 0;

    private static Node dfs(int n, int parent, int level, int cnt, long cntSum) {
        Node node = new Node();

        for (int c : path.get(n)) {
            if (c == parent)
                continue;

            Node child = dfs(c, n, level + 1, cnt, cntSum);

            node.cnt += child.cnt;
            node.cntSum += child.cntSum;
            cnt += child.cnt;
            cntSum += child.cntSum;
        }

        total += (long) cnt * level + cntSum;
        node.cntSum += node.cnt;

        return node;
    }

    private static class Node {
        int cnt = 1;
        long cntSum = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            path.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            path.get(a).add(b);
            path.get(b).add(a);
        }

        dfs(1, 0, 0, 0, 0);
        bw.write(Long.toString(total));
        br.close();
        bw.close();
    }
}
