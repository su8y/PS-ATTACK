/*
 * 문제: 백준 13549번 - 숨바꼭질 3 (https://www.acmicpc.net/problem/13549)
 * 문제 풀이
 *  0-1 BFS로 최단 경로를 구함
 *  0-1 BFS는 가중치가 0과 1로만 주어진 그래프에서 최단 경로를 찾을 때 사용하는 알고리즘. 시간 복잡도는 O(V+E)
 *  현재 노드까지의 가중치 + 다음 노드로 향하는 가중치보다 다음 노드까지의 가중치가 크면 갱신.
 *  갱신된 노드에서 다음 노드로 향하는 가중치가 0이면 덱의 front, 1이면 back에 삽입.
 *
 * 시간 복잡도: O(m) - m: 이동 가능한 위치의 범위
 */

package Baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    // public class Main {
    public static class Node {
        int pos, sec;

        public Node(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        deque.add(new Node(n, 0));

        while (!deque.isEmpty()) {
            Node node = deque.pop();

            if (visited[node.pos])
                continue;

            if (node.pos == k) {
                bw.write(node.sec + "");
                break;
            }

            if (node.pos <= 50000)
                deque.addFirst(new Node(node.pos * 2, node.sec));

            if (node.pos < k)
                deque.addLast(new Node(node.pos + 1, node.sec + 1));

            if (node.pos > 0)
                deque.addLast(new Node(node.pos - 1, node.sec + 1));

            visited[node.pos] = true;
        }

        br.close();
        bw.close();
    }
}
