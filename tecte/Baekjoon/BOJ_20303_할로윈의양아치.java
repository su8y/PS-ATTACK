/*
 * 문제: 백준 20303번 - 할로윈의 양아치 (https://www.acmicpc.net/problem/20303)
 * 문제 풀이
 *  Union-Find로 친구 관계에 있는 아이들을 그룹으로 만듦.
 *  각 그룹의 아이들 수는 무게로, 사탕 개수는 가치로 간주하여 배낭 DP를 수행.
 *
 * 시간 복잡도: O(n * k)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20303_할로윈의양아치 {
    // public class Main {
    private static Map<Integer, Group> map;
    private static int[] parents;

    private static int find(int e) {
        return parents[e] == e ? e : (parents[e] = find(parents[e]));
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        Group groupA = map.get(rootA);
        Group groupB = map.get(rootB);

        if (rootA < rootB) {
            parents[rootB] = rootA;
            groupA.children += groupB.children;
            groupA.candy += groupB.candy;
            map.remove(rootB);
        } else if (rootA > rootB) {
            parents[rootA] = rootB;
            groupB.children += groupA.children;
            groupB.candy += groupA.candy;
            map.remove(rootA);
        }
    }

    private static class Group {
        int children, candy;

        public Group(int children, int candy) {
            this.children = children;
            this.candy = candy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] memo = new int[k];

        map = new HashMap<>(n);
        parents = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            map.put(i, new Group(1, Integer.parseInt(st.nextToken())));
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (Group group : map.values()) {
            int[] newMemo = new int[k];

            for (int i = 1; i < k; i++) {
                newMemo[i] = i < group.children ? memo[i] : Math.max(memo[i], memo[i - group.children] + group.candy);
            }

            memo = newMemo;
        }

        bw.write(Integer.toString(memo[k - 1]));
        br.close();
        bw.close();
    }
}
