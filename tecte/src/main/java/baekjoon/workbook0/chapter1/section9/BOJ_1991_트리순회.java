/*
 * 문제: 백준 1991번 - 트리 순회 (https://www.acmicpc.net/problem/1991)
 *
 * 시간 복잡도: O(n)
 */

package baekjoon.workbook0.chapter1.section9;

import java.io.*;
import java.util.*;

public class BOJ_1991_트리순회 {
    // public class Main {
    private static HashMap<Character, String> map = new HashMap<>();

    private static String preorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return node + preorder(children[0]) + preorder(children[1]);
    }

    private static String inorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return inorder(children[0]) + node + inorder(children[1]);
    }

    private static String postorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return postorder(children[0]) + postorder(children[1]) + node;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken().charAt(0), st.nextToken() + st.nextToken());
        }

        bw.write(preorder('A'));
        bw.newLine();
        bw.write(inorder('A'));
        bw.newLine();
        bw.write(postorder('A'));
        br.close();
        bw.close();
    }
}
