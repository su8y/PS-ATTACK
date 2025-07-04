/*
 * 문제: 백준 1976번 - 여행 가자 (https://www.acmicpc.net/problem/1976)
 * 문제 풀이
 *  union-find로 여행 계획의 도시들이 같은 집합에 속하는지 확인.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
    // public class Main {
    static int[] parents;

    static int find(int c) {
        return c == parents[c] ? c : (parents[c] = find(parents[c]));
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB)
            parents[rootB] = rootA;
        else
            parents[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        String result = "YES";

        for (int i = 1; i <= n; i++)
            parents[i] = i;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++)
                if (st.nextToken().charAt(0) == '1')
                    union(i, j);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = find(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < m; i++) {
            if (parent != find(Integer.parseInt(st.nextToken()))) {
                result = "NO";
                break;
            }
        }

        bw.write(result);
        br.close();
        bw.close();
    }
}
