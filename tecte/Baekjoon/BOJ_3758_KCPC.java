/*
 * 문제: 백준 3758번 - KCPC (https://www.acmicpc.net/problem/3758)
 *
 * 시간 복잡도: O(t * n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3758_KCPC {
    // public class Main {
    static class Team {
        Map<Integer, Integer> map = new HashMap<>();
        int id;
        int submit = 0;
        int time = 0;
        int score = 0;

        public Team(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            Team[] teams = new Team[n];

            for (int i = 0; i < n; i++)
                teams[i] = new Team(i);

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()) - 1;
                int pId = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int ps = teams[id].map.getOrDefault(pId, 0);

                teams[id].submit++;
                teams[id].time = i;

                if (ps < s) {
                    teams[id].map.put(pId, s);
                    teams[id].score += s - ps;
                }
            }

            Arrays.sort(teams, Comparator.comparingInt((Team a) -> -a.score)
                    .thenComparingInt(a -> a.submit)
                    .thenComparingInt(a -> a.time));

            for (int i = 0; i < n; i++) {
                if (teams[i].id == t) {
                    bw.write(Integer.toString(i + 1));
                    bw.newLine();
                    break;
                }
            }
        }

        br.close();
        bw.close();
    }
}
