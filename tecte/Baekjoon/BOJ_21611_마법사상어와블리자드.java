/*
 * 문제: 백준 21611번 - 마법사 상어와 블리자드 (https://www.acmicpc.net/problem/21611)
 *
 * 시간 복잡도: O(m * n^4)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21611_마법사상어와블리자드 {
    // public class Main {
    private static int n;
    private static Bead root;

    private static void setBead(int[][] arr) {
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int d = 0;
        int x = n >> 1;
        int y = n >> 1;
        double len = 1;
        Bead prev = new Bead(1, arr[x][y]);

        root = prev;

        while (true) {
            for (int i = 1; i <= len; i++) {
                x += dir[d][0];
                y += dir[d][1];

                if (x < 0 || x >= n || y < 0 || y >= n || arr[x][y] == 0) {
                    return;
                }

                Bead bead = new Bead(prev.idx + 1, arr[x][y]);

                bead.prev = prev;
                prev.next = bead;
                prev = bead;
            }

            d = (d + 1) % 4;
            len += .5;
        }
    }

    private static class Bead {
        int idx, num, cons;
        Bead prev, next;

        public Bead(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][n];
        int[] explosion = new int[4];

        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        setBead(field);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int idx = 1;
            int step;
            Bead bead = root;
            Bead newBead = root;

            if (d == 1) {
                step = 7;
            } else if (d == 2) {
                step = 3;
            } else if (d == 3) {
                step = 1;
            } else {
                step = 5;
            }

            for (int j = 0; j < s; j++) {
                idx += step;
                step += 8;

                while (bead != null) {
                    if (bead.idx == idx) {
                        bead.prev.next = bead.next;

                        if (bead.next != null) {
                            bead.next.prev = bead.prev;
                        }

                        break;
                    }

                    bead = bead.next;
                }
            }

            while (true) {
                boolean flag = true;
                int cons = 0;
                bead = root.next;

                while (bead != null) {
                    bead.cons = ++cons;

                    if (bead.next == null || bead.num != bead.next.num) {
                        if (cons > 3) {
                            for (int j = 0; j < cons; j++) {
                                bead.prev.next = bead.next;

                                if (bead.next != null) {
                                    bead.next.prev = bead.prev;
                                }

                                explosion[bead.num]++;
                                bead = bead.prev;
                            }

                            flag = false;
                        }

                        cons = 0;
                    }

                    bead = bead.next;
                }

                if (flag) {
                    break;
                }
            }

            bead = root.next;
            idx = 1;

            while (bead != null) {
                if (bead.next != null && bead.num == bead.next.num) {
                    bead = bead.next;
                    continue;
                } else if (++idx > n * n) {
                    break;
                }

                newBead.next = new Bead(idx, bead.cons);
                newBead.next.prev = newBead;
                newBead = newBead.next;

                if (++idx > n * n) {
                    break;
                }

                newBead.next = new Bead(idx, bead.num);
                newBead.next.prev = newBead;
                newBead = newBead.next;
                bead = bead.next;
            }
        }

        bw.write(Integer.toString(explosion[1] + 2 * explosion[2] + 3 * explosion[3]));
        br.close();
        bw.close();
    }
}
