/*
 * 문제: 백준 9436번 - Round Robin (https://www.acmicpc.net/problem/9436)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9436_RoundRobin {
    // public class Main {
    private static boolean isEqual(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i - 1))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 1) {
                break;
            }

            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            List<Integer> players = new ArrayList<>(n);
            int pos = -1;

            for (int i = 0; i < n; i++) {
                players.add(0);
            }

            while (!players.isEmpty()) {
                for (int i = 0; i < t; i++) {
                    pos = ++pos % players.size();
                    players.set(pos, players.get(pos) + 1);
                }

                players.remove(pos--);

                if (isEqual(players)) {
                    sb.append(players.size()).append(" ").append(players.get(0)).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
