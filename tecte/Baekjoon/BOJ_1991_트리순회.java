/*
 * 문제 : 백준 1991번 - 트리 순회 (https://www.acmicpc.net/problem/1991)
 */

package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
    static HashMap<Character, String> map = new HashMap<>();

    // public class Main {
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

    public static String preorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return node + preorder(children[0]) + preorder(children[1]);
    }

    public static String inorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return inorder(children[0]) + node + inorder(children[1]);
    }

    public static String postorder(char node) {
        if (node == '.')
            return "";

        char[] children = map.get(node).toCharArray();

        return postorder(children[0]) + postorder(children[1]) + node;
    }
}
