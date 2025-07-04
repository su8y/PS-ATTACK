/*
 * 문제: 백준 16235번 - 나무 재테크 (https://www.acmicpc.net/problem/16235)
 * 문제 풀이
 *  우선순위 큐로 나무를 나이 순서대로 처리.
 *
 * 시간 복잡도: O(k * n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
    // public class Main {
    private static class Tree {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] land = new int[n][n];
        int[][] nutrient = new int[n][n];
        PriorityQueue<Tree> trees = new PriorityQueue<>(Comparator.comparingInt(a -> a.age));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                land[i][j] = 5;
                nutrient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken());

            trees.offer(new Tree(x, y, a));
        }

        for (int t = 0; t < k; t++) {
            int[][] newLand = new int[n][n];
            PriorityQueue<Tree> newTrees = new PriorityQueue<>(Comparator.comparingInt(a -> a.age));

            while (!trees.isEmpty()) {
                Tree tree = trees.poll();
                int x = tree.x;
                int y = tree.y;
                int age = tree.age;

                if (tree.age > land[x][y]) {
                    newLand[x][y] += age >> 1;
                    continue;
                }

                land[x][y] -= age;
                newTrees.offer(new Tree(x, y, ++age));

                if (age % 5 == 0) {
                    for (int[] d : new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}) {
                        int nx = x + d[0];
                        int ny = y + d[1];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < n)
                            newTrees.offer(new Tree(nx, ny, 1));
                    }
                }
            }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    newLand[i][j] += land[i][j] + nutrient[i][j];

            land = newLand;
            trees = newTrees;
        }

        bw.write(Integer.toString(trees.size()));
        br.close();
        bw.close();
    }
}
