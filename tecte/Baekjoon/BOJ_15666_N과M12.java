/*
 * 문제 : 백준 15666번 - N과 M (12) (https://www.acmicpc.net/problem/15666)
 * 문제 풀이
 *  백트래킹을 사용해서 사전 순으로 증가하는 수열을 구함.
 *  입력받은 수열을 TreeSet에 저장해서 중복되는 수를 없애고 오름차순으로 정렬.
 *  m번만큼 재귀호출해서 수열이 사전 순으로 증가하게 함.
 *  재귀호출할 때 이전에 고른 수를 넘겨줘서 이전에 고른 수보다 같거나 커야 수를 고를 수 있게 함.
 *  LinkedHashSet으로 수열이 중복되지 않게 함.
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_15666_N과M12 {
    // public class Main {
    static int n;
    static int m;
    static TreeSet<Integer> num = new TreeSet<>();
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            num.add(Integer.parseInt(st.nextToken()));

        dfs(1, 0, "");

        for (String sequence : set)
            bw.write(sequence + "\n");

        br.close();
        bw.close();
    }

    static void dfs(int depth, int preNum, String sequence) {
        if (depth > m)
            set.add(sequence);
        else
            for (int i : num)
                if (i >= preNum)
                    dfs(depth + 1, i, sequence + i + " ");
    }
}
