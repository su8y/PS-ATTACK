/*
 * 문제: 백준 15663 - N과 M (9) (https://www.acmicpc.net/problem/15663)
 * 문제 풀이
 *  백트래킹을 사용해서 사전 순으로 증가하는 수열을 구함.
 *  입력받은 배열을 오름차순으로 정렬하고 m번만큼 재귀호출해서 수열이 사전 순으로 증가하게 함.
 *  이 때, 비트 마스크로 이미 고른 수를 다시 고르지 않게 함.
 *  LinkedHashSet으로 수열이 중복되지 않게 함.
 *
 * 시간 복잡도: O(m * n! / (n-m)!)
 */

package baekjoon.workbook1.chapter5.section6;

import java.io.*;
import java.util.*;

public class BOJ_15663_N과M9 {
    // public class Main {
    private static int n;
    private static int m;
    private static int[] num;
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    private static void dfs(int depth, int visited, String sequence) {
        if (depth > m)
            set.add(sequence);
        else
            for (int i = 0; i < n; i++)
                if ((visited & (1 << i)) == 0)
                    dfs(depth + 1, visited | (1 << i), sequence + num[i] + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(num);
        dfs(1, 0, "");

        for (String sequence : set)
            bw.write(sequence + "\n");

        br.close();
        bw.close();
    }
}
