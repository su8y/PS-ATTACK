/*
 * 문제: 백준 2263번 - 트리의 순회 (https://www.acmicpc.net/problem/2263)
 * 문제 풀이
 *  후위 순회의 마지막 노드가 루트 노드라는 점을 이용하여 중위 순회에서 루트 노드를 찾아 왼쪽 서브트리와 오른쪽 서브트리로 분할.
 *  분할 정복으로 트리를 복원한 후, 전위 순회를 수행.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2263_트리의순회 {
    // public class Main {
    private static int[] inOrder, postOrder;
    private static int pos;

    private static Node reconstructTree(int s, int e) {
        if (s > e) {
            return null;
        }

        Node node = new Node(postOrder[pos--]);
        int root = inOrder[node.root];

        node.right = reconstructTree(root + 1, e);
        node.left = reconstructTree(s, root - 1);

        return node;
    }

    private static void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.root).append(" ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private static class Node {
        int root;
        Node left, right;

        public Node(int root) {
            this.root = root;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        inOrder = new int[n + 1];
        postOrder = new int[n + 1];
        pos = n;

        for (int i = 1; i <= n; i++) {
            inOrder[Integer.parseInt(st1.nextToken())] = i;
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }

        preOrder(reconstructTree(1, n), sb);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
