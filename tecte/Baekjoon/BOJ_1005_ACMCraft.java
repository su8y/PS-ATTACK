/*
 * 문 제 : 백준 1005번 - ACM Craft (https://www.acmicpc.net/problem/1005)
 * 문제 풀이
 *  dp로만 풀면 시간 초과가 떠서 위상 정렬도 이용해 풀어야 함
 *  건설순서 규칙인 x(지어야 하는 건물), y(x를 짓고 난 다음에 지을 수 있는 건물들)는 ArrayList<>[x]에 y를 추가
 *  건설순서 규칙을 ArrayList<>[]에 넣을 때 y의 진입차수를 증가시킴
 *  배열 dp에는 특정 건물을 짓는데 먼저 완공되어 있어야 하는 건물들 중 가장 오래 걸리는 시간과 특정 건물을 짓는 시간을 더한 값을 저장
 *  n개의 건물들을 반복문으로 돌면서 진입차수가 0인 건물들을 큐에 삽입, 만약 반복문이 끝나지 않았는데 큐가 비어버리면 사이클이 발생한 것
 *  큐에서 지어야 하는 건물(x)를 빼면서 y의 진입차수를 감소, dp[y]의 값과 (dp[x] + y의 건설 시간)의 값을 비교해 큰 값을 dp[y]에 저장
 *  만약 x가 승리하기 위해 지어야하는 건물이라면 반복문을 빠져나오며 그 건물의 dp값 출력
 *
 * 시간 복잡도: O(t * (n + k))
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1005_ACMCraft {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 건물의 개수
            int k = Integer.parseInt(input[1]); // 건설순서 규칙의 총 개수
            int[] buildTime = new int[n + 1]; // 건설에 걸리는 시간
            ArrayList<Integer>[] buildable = new ArrayList[n + 1]; // 건물을 짓고 그 다음에 지을 수 있는 건물들
            int[] dp = new int[n + 1]; // 건물을 짓는데 걸리는 최대 시간
            int[] inDegree = new int[n + 1]; // 건물들의 진입차수
            Queue<Integer> queue = new LinkedList<>();

            input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                buildable[i] = new ArrayList<>();
                dp[i] = buildTime[i] = Integer.parseInt(input[i - 1]);
            }

            for (int i = 0; i < k; i++) { // 입력 받은 건설순서 규칙을 buildable에 넣음
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]); // 지어야 하는 건물
                int y = Integer.parseInt(input[1]); // x를 짓고 난 다음에 지을 수 있는 건물

                buildable[x].add(y); // x를 짓고 y를 지을 수 있기 때문에 buildable[x]에 y 추가
                inDegree[y]++; // y의 진입차수 증가
            }

            int w = Integer.parseInt(br.readLine()); // 승리하기 위해 건설해야 할 특정 건물

            for (int i = 1; i <= n; i++)
                if (inDegree[i] == 0) // 진입차수가 0인 건물을 큐에 삽입
                    queue.offer(i);

            for (int i = 1; i <= n; i++) {
                if (queue.isEmpty()) // 건물들을 다 방문하기 전에 큐가 비어버리면 사이클이 발생한 것
                    break;

                int building = queue.poll(); // 지어야 하는 건물을 큐에서 꺼냄

                // 지어야 하는 건물이 승리하기 위해 지어야 하는 건물이라면 반복문 탈출
                if (building == w)
                    break;

                for (int b : buildable[building]) { // b는 건물을 짓고 그 다음에 지을 수 있는 건물
                    // dp[b]와 (지어야 하는 건물의 dp값 + b의 건설 시간)을 비교해 큰 값을 dp[b]에 저장
                    dp[b] = Math.max(dp[b], dp[building] + buildTime[b]);
                    inDegree[b]--; // b의 진입차수 감소

                    if (inDegree[b] == 0) // 새롭게 진입차수가 0인 된 건물들을 큐에 삽입
                        queue.offer(b);
                }
            }

            bw.write(Integer.toString(dp[w]));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
