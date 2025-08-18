/*
 * 문 제 : 백준 9205번 - 맥주 마시면서 걸어가기 (https://www.acmicpc.net/problem/9205)
 * 문제 풀이
 *  BFS로 풀기 위해 처음에는 큐에 상근이네 집 위치를 넣고 큐가 빌 때까지 반복문을 돌림
 *  반복문에서 큐에서 위치를 하나 빼서 그 위치에서 아직 방문하지 않은 위치들 중 갈 수 있는 위치들을 확인
 *  갈 수 있는 위치들을 방문했다고 바꾸고 큐에 삽입
 *  반복문이 끝났을 때 페스티벌 방문 여부가 true이면 happy를 출력하고 아니면 sad를 출력
 */

package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// public class Main {
public class BOJ_9205_맥주마시면서걸어가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] pos = new int[n + 2][2];

            for (int i = 0; i < n + 2; i++) {
                String[] input = br.readLine().split(" ");
                pos[i][0] = Integer.parseInt(input[0]);
                pos[i][1] = Integer.parseInt(input[1]);
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[] check = new boolean[n + 2];

            queue.offer(pos[0]);
            check[0] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int i = 1; i < n + 2; i++) {
                    if (!check[i] && (Math.abs(pos[i][0] - now[0]) + Math.abs(pos[i][1] - now[1]) <= 1000)) {
                        queue.offer(pos[i]);
                        check[i] = true;
                    }
                }
            }

            if (check[n + 1])
                bw.write("happy");
            else
                bw.write("sad");

            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}