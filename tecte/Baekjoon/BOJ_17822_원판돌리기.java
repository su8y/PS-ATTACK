/*
 * 문제 : 백준 17822번 - 원판 돌리기 (https://www.acmicpc.net/problem/17822)
 *
 * 시간 복잡도: O( t * n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17822_원판돌리기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] disk = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            disk[i] = new ArrayList<>(m);
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++)
                disk[i].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int sum = 0;
            int cnt = 0;
            boolean[][] remove = new boolean[n + 1][m];
            ArrayList<Integer>[] newDisk = new ArrayList[n + 1];

            for (int j = x; j <= n; j += x) {
                int splitIndex = d == 0 ? m - k : k;
                ArrayList<Integer> front = new ArrayList<>(disk[j].subList(0, splitIndex));
                ArrayList<Integer> back = new ArrayList<>(disk[j].subList(splitIndex, m));

                back.addAll(front);
                disk[j] = back;
            }

            bw.write("회전");
            bw.newLine();
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < m; l++) {
                    bw.write(disk[j].get(l) + " ");
                }
                bw.newLine();
            }
            bw.newLine();

            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < m; l++) {
                    if (disk[j].get(l) > 0) {
                        int left = (m + l - 1) % m;
                        int right = (m + l + 1) % m;

                        if (disk[j].get(l).equals(disk[j].get(left))) {
                            flag = true;
                            remove[j][l] = true;
                            remove[j][left] = true;
                        }

                        if (disk[j].get(l).equals(disk[j].get(right))) {
                            flag = true;
                            remove[j][l] = true;
                            remove[j][right] = true;
                        }

                        if (j - 1 > 0 && disk[j].get(l).equals(disk[j - 1].get(l))) {
                            flag = true;
                            remove[j][l] = true;
                            remove[j - 1][l] = true;
                        }

                        if (j + 1 <= n && disk[j].get(l).equals(disk[j + 1].get(l))) {
                            flag = true;
                            remove[j][l] = true;
                            remove[j + 1][l] = true;
                        }

                        sum += disk[j].get(l);
                        cnt++;
                    }
                }
            }

            double avg = (double) sum / cnt;

            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < m; l++) {
                    if (flag) {
                        if (remove[j][l])
                            disk[j].set(l, 0);
                    } else if (disk[j].get(l) > 0) {
                        if (disk[j].get(l) > avg)
                            disk[j].set(l, disk[j].get(l) - 1);
                        else if (disk[j].get(l) < avg)
                            disk[j].set(l, disk[j].get(l) + 1);
                    }
                }
            }

            bw.write("인접");
            bw.newLine();
            for (int j = 1; j <= n; j++) {
                for (int l = 0; l < m; l++) {
                    bw.write(disk[j].get(l) + " ");
                }
                bw.newLine();
            }
            bw.newLine();
        }

        int sum = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < m; j++)
                sum += disk[i].get(j);

        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
