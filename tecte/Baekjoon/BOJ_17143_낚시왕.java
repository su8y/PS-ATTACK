/*
 * 문제: 백준 17143번 - 낚시왕 (https://www.acmicpc.net/problem/17143)
 *
 * 시간 복잡도: O(c * m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17143_낚시왕 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, int[]> shark = new HashMap<>(m);
        int sum = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            shark.put(z, new int[]{r, c, s, d});
        }

        for (int i = 1; i <= C; i++) {
            HashMap<Integer, int[]> newShark = new HashMap<>();
            int[][] sea = new int[R + 1][C + 1];
            int min = R + 1;
            int hit = 0;

            for (Map.Entry<Integer, int[]> entry : shark.entrySet()) {
                if (entry.getValue()[1] == i && entry.getValue()[0] < min) {
                    min = entry.getValue()[0];
                    hit = entry.getKey();
                }
            }

            shark.remove(hit);
            sum += hit;

            for (Map.Entry<Integer, int[]> entry : shark.entrySet()) {
                int[] value = entry.getValue();
                int distance = value[2];

                switch (value[3]) {
                    case 1:
                        distance += R - value[0];
                        break;
                    case 2:
                        distance += value[0] - 1;
                        break;
                    case 3:
                        distance += value[1] - 1;
                        break;
                    case 4:
                        distance += C - value[1];
                        break;
                }

                if (value[3] > 2) {
                    while (distance >= C) {
                        distance -= C - 1;
                        value[3] = 3 + value[3] % 2;
                    }
                } else {
                    while (distance >= R) {
                        distance -= R - 1;
                        value[3] = 1 + value[3] % 2;
                    }
                }

                switch (value[3]) {
                    case 1:
                        value[0] = R - distance;
                        break;
                    case 2:
                        value[0] = distance + 1;
                        break;
                    case 3:
                        value[1] = distance + 1;
                        break;
                    case 4:
                        value[1] = C - distance;
                        break;
                }

                newShark.put(entry.getKey(), value);

                if (sea[value[0]][value[1]] < entry.getKey()) {
                    newShark.remove(sea[value[0]][value[1]]);
                    sea[value[0]][value[1]] = entry.getKey();
                } else {
                    newShark.remove(entry.getKey());
                }
            }

            shark = newShark;
        }

        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
