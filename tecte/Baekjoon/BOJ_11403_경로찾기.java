/*
 * 문제 : 백준 11403번 - 경로 찾기 (https://www.acmicpc.net/problem/11403)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++)
                if (st.nextToken().equals("1"))
                    graph[i][j] = true;
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (graph[i][k] && graph[k][j])
                        graph[i][j] = true;

        for (boolean[] i : graph) {
            for (boolean j : i) {
                if (j)
                    bw.write("1 ");
                else
                    bw.write("0 ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
