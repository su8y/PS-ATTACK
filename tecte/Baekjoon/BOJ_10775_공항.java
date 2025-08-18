/*
 * 문제: 백준 10775번 - 공항 (https://www.acmicpc.net/problem/10775)
 * 문제 풀이
 *  그리디와 Union-Find를 사용.
 *  비행기를 가능한 가장 큰 번호의 게이트에 도킹.
 *  도킹이 완료된 게이트는 하나 작은 번호의 게이트에 연결하여 다음 비행기의 선택지를 제한.
 *
 * 시간 복잡도: O(g + p)
 */

package Baekjoon;

import java.io.*;

public class BOJ_10775_공항 {
    // public class Main {
    private static int[] gates;
    private static int cnt = 0;

    private static int find(int e) {
        return gates[e] == e ? e : (gates[e] = find(gates[e]));
    }

    private static boolean union(int e) {
        int root = find(e);

        if (root == 0) {
            return false;
        }

        gates[root] = find(root - 1);
        cnt++;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        boolean flag = true;

        gates = new int[g + 1];

        for (int i = 1; i <= g; i++) {
            gates[i] = i;
        }

        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());

            if (flag) {
                flag = union(Math.min(g, plane));
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
