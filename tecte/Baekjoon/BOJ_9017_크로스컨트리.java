/*
 * 문제: 백준 9017번 - 크로스 컨트리 (https://www.acmicpc.net/problem/9017)
 *
 * 시간 복잡도: O(T * N)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9017_크로스컨트리 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] scoring = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> team = new HashMap<>();
            Map<Integer, List<Integer>> score = new HashMap<>();
            int rank = 1;
            int win = 0;
            int winScore = Integer.MAX_VALUE;

            for (int i : scoring)
                team.put(i, team.getOrDefault(i, 0) + 1);

            for (int i : scoring) {
                if (team.get(i) < 6)
                    continue;

                List<Integer> list = score.getOrDefault(i, new ArrayList<>());

                list.add(rank++);
                score.put(i, list);
            }

            for (Map.Entry<Integer, List<Integer>> entry : score.entrySet()) {
                int teamScore = entry.getValue().stream().limit(4).mapToInt(Integer::intValue).sum();

                if (winScore > teamScore || (winScore == teamScore && score.get(win).get(4) > entry.getValue().get(4))) {
                    win = entry.getKey();
                    winScore = teamScore;
                }
            }

            bw.write(Integer.toString(win));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
