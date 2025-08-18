/*
 * 문제 : 백준 11725번 - 트리의 부모 찾기 (https://www.acmicpc.net/problem/11725)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리의부모찾기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i < n; i++) {
            int[] node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (!tree.containsKey(node[0]))
                tree.put(node[0], new ArrayList<>());

            if (!tree.containsKey(node[1]))
                tree.put(node[1], new ArrayList<>());

            tree.get(node[0]).add(node[1]);
            tree.get(node[1]).add(node[0]);
        }

        queue.offer(1);
        result[1] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : tree.get(parent)) {
                if (result[child] == 0) {
                    queue.offer(child);
                    result[child] = parent;
                }
            }
        }

        for (int i = 2; i <= n; i++)
            bw.write(result[i] + "\n");

        br.close();
        bw.close();
    }
}
