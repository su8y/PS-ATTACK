/*
 * 문제: 백준 21608번 - 상어 초등학교 (https://www.acmicpc.net/problem/21608)
 *
 * 시간 복잡도: O(n^4)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
    // public class Main {
    private static class Seat {
        int x, y;
        int pref = 0;
        int empty = 0;

        public Seat(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] classroom = new int[n + 1][n + 1];
        boolean[][] preferences = new boolean[n * n + 1][n * n + 1];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int sat = 0;

        for (int i = n * n; i > 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            Seat seat = new Seat(n + 1, n + 1);

            for (int j = 0; j < 4; j++) {
                preferences[student][Integer.parseInt(st.nextToken())] = true;
            }

            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (classroom[x][y] != 0) {
                        continue;
                    }

                    Seat newSeat = new Seat(x, y);

                    for (int[] d : dir) {
                        int nx = x + d[0];
                        int ny = y + d[1];

                        if (nx < 1 || nx > n || ny < 1 || ny > n) {
                            continue;
                        }

                        if (classroom[nx][ny] == 0) {
                            newSeat.empty++;
                        } else if (preferences[student][classroom[nx][ny]]) {
                            newSeat.pref++;
                        }
                    }

                    if (newSeat.pref > seat.pref) {
                        seat = newSeat;
                    } else if (newSeat.pref == seat.pref) {
                        if (newSeat.empty > seat.empty) {
                            seat = newSeat;
                        } else if (newSeat.empty == seat.empty) {
                            if (newSeat.x < seat.x) {
                                seat = newSeat;
                            } else if (newSeat.x == seat.x) {
                                if (newSeat.y < seat.y) {
                                    seat = newSeat;
                                }
                            }
                        }
                    }
                }
            }

            classroom[seat.x][seat.y] = student;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = -1;

                for (int[] d : dir) {
                    int nx = i + d[0];
                    int ny = j + d[1];

                    if (nx < 1 || nx > n || ny < 1 || ny > n) {
                        continue;
                    }

                    if (preferences[classroom[i][j]][classroom[nx][ny]]) {
                        cnt++;
                    }
                }

                sat += (int) Math.pow(10, cnt);
            }
        }

        bw.write(Integer.toString(sat));
        br.close();
        bw.close();
    }
}
