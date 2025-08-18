/*
 * 문제: 백준 16724번 - 피리 부는 사나이 (https://www.acmicpc.net/problem/16724)
 * 문제 풀이
 *  Union-Find로 연결되어 있는 칸들을 집합으로 병합.
 *  집합의 개수가 SAFE ZONE의 최소 개수.
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16724_피리부는사나이 {
    // public class Main {
    private static int[] parents;
    private static int cnt;

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        } else if (rootA < rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }

        cnt--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cnt = n * m;
        parents = new int[cnt];

        for (int i = 1; i < cnt; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            char[] dir = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                int a = m * i + j;
                int b = a;

                if (dir[j] == 'U') {
                    b -= m;
                } else if (dir[j] == 'D') {
                    b += m;
                } else if (dir[j] == 'L') {
                    b--;
                } else {
                    b++;
                }

                union(a, b);
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
