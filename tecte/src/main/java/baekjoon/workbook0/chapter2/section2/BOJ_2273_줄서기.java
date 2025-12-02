/*
 * 문제: 백준 2273번 - 줄 서기 (https://www.acmicpc.net/problem/2273)
 * 문제 풀이
 *  A가 B보다 클 때 A->B 형식의 그래프로 생각하고 플로이드 워셜 알고리즘을 적용.
 *  노드 n에서 갈 수 있는 노드의 개수(end)와 노드 n으로 올 수 있는 노드의 개수(start)를 구하여 1+start, N-end
 *  A<B, B<C, C<A와 같은 사이클이 발생하는 경우 예외처리 해야됨.
 *  A노드에서 B노드로 도달이 가능한데 B노드에서 A노드로 도달이 가능하면 사이클이 발생한 것.
 *
 * 시간 복잡도: O(n³)
 */

package baekjoon.workbook0.chapter2.section2;

import java.io.*;

public class BOJ_2273_줄서기 {
    // public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] students = new int[n][n];
        int max = 257;
        String str = "";

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                students[i][j] = max;

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;

            students[x][y] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || students[i][k] == max || students[k][j] == max)
                        continue;

                    students[i][j] = Math.min(students[i][j], students[i][k] + students[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int start = 1;
            int end = n;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (students[i][j] != max && students[j][i] != max) {
                    bw.write("-1");
                    bw.flush();
                    br.close();
                    bw.close();

                    return;
                }

                if (students[i][j] != max)
                    end--;

                if (students[j][i] != max)
                    start++;
            }

            str += start + " " + end + "\n";
        }

        bw.write(str);
        br.close();
        bw.close();
    }
}
