/*
 * 문제 : 백준 19236번 - 청소년 상어 (https://www.acmicpc.net/problem/19236)
 *
 * 시간 복잡도: O(3^16)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {
    // public class Main {
    private static int move(int[][] sea, int[][] fish, int x, int y, int sum) {
        int[][] newSea = new int[4][4];
        int[][] newFish = new int[17][3];

        for (int i = 0; i < 4; i++)
            newSea[i] = sea[i].clone();

        for (int i = 1; i < 17; i++)
            newFish[i] = fish[i].clone();

        int num = newSea[x][y];
        int sd = newFish[num][2];
        int[][] d = {{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

        newSea[x][y] = 0;
        newFish[num] = new int[]{-1, -1, -1};
        sum += num;

        for (int i = 1; i < 17; i++) {
            if (newFish[i][0] >= 0) {
                int fx = newFish[i][0];
                int fy = newFish[i][1];
                int fd = newFish[i][2];
                int nfx = fx + d[fd][0];
                int nfy = fy + d[fd][1];

                for (int j = 0; j < 8; j++) {
                    if (nfx < 0 || nfx >= 4 || nfy < 0 || nfy >= 4 || (nfx == x && nfy == y)) {
                        fd = fd % 8 + 1;
                        nfx = fx + d[fd][0];
                        nfy = fy + d[fd][1];
                    } else if (newSea[nfx][nfy] == 0) {
                        newSea[fx][fy] = 0;
                        newSea[nfx][nfy] = i;
                        newFish[i] = new int[]{nfx, nfy, fd};
                        break;
                    } else {
                        newSea[fx][fy] = newSea[nfx][nfy];
                        newSea[nfx][nfy] = i;
                        newFish[newSea[fx][fy]][0] = fx;
                        newFish[newSea[fx][fy]][1] = fy;
                        newFish[i] = new int[]{nfx, nfy, fd};
                        break;
                    }
                }
            }
        }

        int result = sum;

        while (true) {
            x += d[sd][0];
            y += d[sd][1];

            if (x < 0 || x >= 4 || y < 0 || y >= 4)
                break;
            else if (newSea[x][y] != 0)
                result = Math.max(result, move(newSea, newFish, x, y, sum));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] sea = new int[4][4];
        int[][] fish = new int[17][3];
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sea[i][j] = a;
                fish[a] = new int[]{i, j, b};
            }
        }

        bw.write(move(sea, fish, 0, 0, sum) + "");
        br.close();
        bw.close();
    }
}
