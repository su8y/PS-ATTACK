/*
 * 문제: 백준 5639번 - 이진 검색 트리 (https://www.acmicpc.net/problem/5639)
 * 문제 풀이
 *  재귀로 입력받은 노드를 이진 트리로 만들고 다시 재귀로 후위 순회를 함.
 *
 * 시간 복잡도: O(n log n) - n: 노드의 수
 */

package Baekjoon;

import java.io.*;

public class BOJ_5639_이진검색트리 {
    // public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void addTree(Node node, int v) {
        if (v < node.v) {
            if (node.left == null)
                node.left = new Node(v);
            else
                addTree(node.left, v);
        } else {
            if (node.right == null)
                node.right = new Node(v);
            else
                addTree(node.right, v);
        }
    }

    static void postorderTraversal(Node node) throws IOException {
        if (node == null)
            return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        bw.write(node.v + "\n");
    }

    static class Node {
        int v;
        Node left, right;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));

        while (true) {
            input = br.readLine();

            if (input == null || input.isEmpty())
                break;

            int n = Integer.parseInt(input);

            addTree(root, n);
        }

        postorderTraversal(root);
        br.close();
        bw.close();
    }
}
