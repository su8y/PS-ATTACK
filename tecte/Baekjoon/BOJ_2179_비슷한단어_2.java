/*
 * 문제: 백준 2179번 - 비슷한 단어 (https://www.acmicpc.net/problem/2179)
 * 문제 풀이
 *  트라이를 구성하면서 공통 접두사의 길이를 확인하고, 최대 접두사 길이를 갱신.
 *  트라이(Trie)는 문자열 검색과 저장을 효율적으로 처리하기 위한 트리 형태의 자료구조.
 *
 * 시간 복잡도: O(n * l) - l: 영단어의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_2179_비슷한단어_2 {
    // public class Main {
    static class Node {
        int idx;
        Node[] alphabet = new Node[26];

        public Node(int idx) {
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        Node root = new Node(-1);
        int wordA = 0;
        int wordB = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            Node node = root;

            words[i] = br.readLine();

            for (int j = 0; j < words[i].length(); j++) {
                int idx = words[i].charAt(j) - 'a';

                if (node.alphabet[idx] == null) {
                    node.alphabet[idx] = new Node(i);
                } else if (j + 1 > len) {
                    len = j + 1;
                    wordA = node.alphabet[idx].idx;
                    wordB = i;
                } else if (j + 1 == len && wordA > node.alphabet[idx].idx) {
                    wordA = node.alphabet[idx].idx;
                    wordB = i;
                }

                node = node.alphabet[idx];
            }
        }

        bw.write(words[wordA]);
        bw.newLine();
        bw.write(words[wordB]);
        br.close();
        bw.close();
    }
}
