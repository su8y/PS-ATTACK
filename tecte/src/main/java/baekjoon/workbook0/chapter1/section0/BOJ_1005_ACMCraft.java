/*
 * 문제: 백준 1005번 - ACM Craft (https://www.acmicpc.net/problem/1005)
 * 문제 풀이
 *  dp로만 풀면 시간 초과가 떠서 위상 정렬도 이용해 풀어야 함.
 *  건설순서 규칙인 x(지어야 하는 건물), y(x를 짓고 난 다음에 지을 수 있는 건물들)는 ArrayList<>[x]에 y를 추가.
 *  건설순서 규칙을 ArrayList<>[]에 넣을 때 y의 진입차수를 증가시킴.
 *  배열 dp에는 특정 건물을 짓는데 먼저 완공되어 있어야 하는 건물들 중 가장 오래 걸리는 시간과 특정 건물을 짓는 시간을 더한 값을 저장.
 *  n개의 건물들을 반복문으로 돌면서 진입차수가 0인 건물들을 큐에 삽입, 만약 반복문이 끝나지 않았는데 큐가 비어버리면 사이클이 발생한 것.
 *  큐에서 지어야 하는 건물(x)를 빼면서 y의 진입차수를 감소, dp[y]의 값과 (dp[x] + y의 건설 시간)의 값을 비교해 큰 값을 dp[y]에 저장.
 *  만약 x가 승리하기 위해 지어야하는 건물이라면 반복문을 빠져나오며 그 건물의 dp값 출력.
 *
 * 시간 복잡도: O(t * (n + k))
 */

package baekjoon.workbook0.chapter1.section0;

import java.io.*;
import java.util.*;

public class BOJ_1005_ACMCraft {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[] buildTime = new int[n + 1];
            ArrayList<Integer>[] buildable = new ArrayList[n + 1];
            int[] dp = new int[n + 1];
            int[] inDegree = new int[n + 1];
            Queue<Integer> queue = new LinkedList<>();

            input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                buildable[i] = new ArrayList<>();
                dp[i] = buildTime[i] = Integer.parseInt(input[i - 1]);
            }

            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                buildable[x].add(y);
                inDegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++)
                if (inDegree[i] == 0)
                    queue.offer(i);

            for (int i = 1; i <= n; i++) {
                if (queue.isEmpty())
                    break;

                int building = queue.poll();

                if (building == w)
                    break;

                for (int b : buildable[building]) {
                    dp[b] = Math.max(dp[b], dp[building] + buildTime[b]);
                    inDegree[b]--;

                    if (inDegree[b] == 0)
                        queue.offer(b);
                }
            }

            bw.write(Integer.toString(dp[w]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
