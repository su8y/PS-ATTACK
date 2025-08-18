/*
 * 문제: 백준 20040번 - 사이클 게임 (https://www.acmicpc.net/problem/20040)
 * 문제 풀이
 *  union-find로 사이클이 발생하는지 찾음. 이으려는 두 점의 대표가 같으면 사이클이 발생한 것.
 *
 * 시간 복잡도: O(m)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {
    // public class Main {
    private static int[] parent;

    private static int find(int e) {
        return e == parent[e] ? e : (parent[e] = find(parent[e]));
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        } else if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        parent = new int[n];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (result == 0 && !union(s, e)) {
                result = i;
            }
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
