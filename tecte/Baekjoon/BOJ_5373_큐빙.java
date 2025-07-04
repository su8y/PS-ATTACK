/*
 * 문제: 백준 5373번 - 큐빙 (https://www.acmicpc.net/problem/5373)
 *
 * 시간 복잡도: O(t * n) - t: 테스트 케이스
 */

package Baekjoon;

import java.io.*;

public class BOJ_5373_큐빙 {
    // public class Main {
    private static class Cell {
        char x;
        char y;
        char z;

        public Cell(char x, char y, char z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Cube {
        char[][][] sides = new char[6][3][3];
        char[] colors = {'w', 'y', 'r', 'o', 'g', 'b'};

        public Cube() {
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 3; j++)
                    for (int k = 0; k < 3; k++)
                        sides[i][j][k] = colors[i];
        }

        void rotate(char side, char dir) {
            char[] temp;
            int s = 0;

            switch (side) {
                case 'U':
                    temp = sides[3][0];

                    if (dir == '+') {
                        sides[3][0] = sides[4][0];
                        sides[4][0] = sides[2][0];
                        sides[2][0] = sides[5][0];
                        sides[5][0] = temp;
                    } else {
                        sides[3][0] = sides[5][0];
                        sides[5][0] = sides[2][0];
                        sides[2][0] = sides[4][0];
                        sides[4][0] = temp;
                    }

                    break;
                case 'D':
                    temp = sides[3][2];
                    s = 1;

                    if (dir == '+') {
                        sides[3][2] = sides[5][2];
                        sides[5][2] = sides[2][2];
                        sides[2][2] = sides[4][2];
                        sides[4][2] = temp;
                    } else {
                        sides[3][2] = sides[4][2];
                        sides[4][2] = sides[2][2];
                        sides[2][2] = sides[5][2];
                        sides[5][2] = temp;
                    }

                    break;
                case 'F':
                    temp = new char[]{sides[0][2][0], sides[0][2][1], sides[0][2][2]};
                    s = 2;

                    if (dir == '+') {
                        sides[0][2][0] = sides[4][2][2];
                        sides[0][2][1] = sides[4][1][2];
                        sides[0][2][2] = sides[4][0][2];
                        sides[4][2][2] = sides[1][0][2];
                        sides[4][1][2] = sides[1][0][1];
                        sides[4][0][2] = sides[1][0][0];
                        sides[1][0][2] = sides[5][0][0];
                        sides[1][0][1] = sides[5][1][0];
                        sides[1][0][0] = sides[5][2][0];
                        sides[5][0][0] = temp[0];
                        sides[5][1][0] = temp[1];
                        sides[5][2][0] = temp[2];
                    } else {
                        sides[0][2][0] = sides[5][0][0];
                        sides[0][2][1] = sides[5][1][0];
                        sides[0][2][2] = sides[5][2][0];
                        sides[5][0][0] = sides[1][0][2];
                        sides[5][1][0] = sides[1][0][1];
                        sides[5][2][0] = sides[1][0][0];
                        sides[1][0][2] = sides[4][2][2];
                        sides[1][0][1] = sides[4][1][2];
                        sides[1][0][0] = sides[4][0][2];
                        sides[4][2][2] = temp[0];
                        sides[4][1][2] = temp[1];
                        sides[4][0][2] = temp[2];
                    }

                    break;
                case 'B':
                    temp = new char[]{sides[0][0][0], sides[0][0][1], sides[0][0][2]};
                    s = 3;

                    if (dir == '+') {
                        sides[0][0][0] = sides[5][0][2];
                        sides[0][0][1] = sides[5][1][2];
                        sides[0][0][2] = sides[5][2][2];
                        sides[5][0][2] = sides[1][2][2];
                        sides[5][1][2] = sides[1][2][1];
                        sides[5][2][2] = sides[1][2][0];
                        sides[1][2][2] = sides[4][2][0];
                        sides[1][2][1] = sides[4][1][0];
                        sides[1][2][0] = sides[4][0][0];
                        sides[4][2][0] = temp[0];
                        sides[4][1][0] = temp[1];
                        sides[4][0][0] = temp[2];
                    } else {
                        sides[0][0][0] = sides[4][2][0];
                        sides[0][0][1] = sides[4][1][0];
                        sides[0][0][2] = sides[4][0][0];
                        sides[4][2][0] = sides[1][2][2];
                        sides[4][1][0] = sides[1][2][1];
                        sides[4][0][0] = sides[1][2][0];
                        sides[1][2][2] = sides[5][0][2];
                        sides[1][2][1] = sides[5][1][2];
                        sides[1][2][0] = sides[5][2][2];
                        sides[5][0][2] = temp[0];
                        sides[5][1][2] = temp[1];
                        sides[5][2][2] = temp[2];
                    }

                    break;
                case 'L':
                    temp = new char[]{sides[0][0][0], sides[0][1][0], sides[0][2][0]};
                    s = 4;

                    if (dir == '+') {
                        sides[0][0][0] = sides[3][2][2];
                        sides[0][1][0] = sides[3][1][2];
                        sides[0][2][0] = sides[3][0][2];
                        sides[3][2][2] = sides[1][0][0];
                        sides[3][1][2] = sides[1][1][0];
                        sides[3][0][2] = sides[1][2][0];
                        sides[1][0][0] = sides[2][0][0];
                        sides[1][1][0] = sides[2][1][0];
                        sides[1][2][0] = sides[2][2][0];
                        sides[2][0][0] = temp[0];
                        sides[2][1][0] = temp[1];
                        sides[2][2][0] = temp[2];
                    } else {
                        sides[0][0][0] = sides[2][0][0];
                        sides[0][1][0] = sides[2][1][0];
                        sides[0][2][0] = sides[2][2][0];
                        sides[2][0][0] = sides[1][0][0];
                        sides[2][1][0] = sides[1][1][0];
                        sides[2][2][0] = sides[1][2][0];
                        sides[1][0][0] = sides[3][2][2];
                        sides[1][1][0] = sides[3][1][2];
                        sides[1][2][0] = sides[3][0][2];
                        sides[3][2][2] = temp[0];
                        sides[3][1][2] = temp[1];
                        sides[3][0][2] = temp[2];
                    }

                    break;
                case 'R':
                    temp = new char[]{sides[0][2][2], sides[0][1][2], sides[0][0][2]};
                    s = 5;

                    if (dir == '+') {
                        sides[0][2][2] = sides[2][2][2];
                        sides[0][1][2] = sides[2][1][2];
                        sides[0][0][2] = sides[2][0][2];
                        sides[2][2][2] = sides[1][2][2];
                        sides[2][1][2] = sides[1][1][2];
                        sides[2][0][2] = sides[1][0][2];
                        sides[1][2][2] = sides[3][0][0];
                        sides[1][1][2] = sides[3][1][0];
                        sides[1][0][2] = sides[3][2][0];
                        sides[3][0][0] = temp[0];
                        sides[3][1][0] = temp[1];
                        sides[3][2][0] = temp[2];
                    } else {
                        sides[0][2][2] = sides[3][0][0];
                        sides[0][1][2] = sides[3][1][0];
                        sides[0][0][2] = sides[3][2][0];
                        sides[3][0][0] = sides[1][2][2];
                        sides[3][1][0] = sides[1][1][2];
                        sides[3][2][0] = sides[1][0][2];
                        sides[1][2][2] = sides[2][2][2];
                        sides[1][1][2] = sides[2][1][2];
                        sides[1][0][2] = sides[2][0][2];
                        sides[2][2][2] = temp[0];
                        sides[2][1][2] = temp[1];
                        sides[2][0][2] = temp[2];
                    }
            }

            if (dir == '+') {
                temp = new char[]{sides[s][0][2], sides[s][0][1]};
                sides[s][0][2] = sides[s][0][0];
                sides[s][0][1] = sides[s][1][0];
                sides[s][0][0] = sides[s][2][0];
                sides[s][1][0] = sides[s][2][1];
                sides[s][2][0] = sides[s][2][2];
                sides[s][2][1] = sides[s][1][2];
                sides[s][2][2] = temp[0];
                sides[s][1][2] = temp[1];
            } else {
                temp = new char[]{sides[s][0][0], sides[s][0][1]};
                sides[s][0][0] = sides[s][0][2];
                sides[s][0][1] = sides[s][1][2];
                sides[s][0][2] = sides[s][2][2];
                sides[s][1][2] = sides[s][2][1];
                sides[s][2][2] = sides[s][2][0];
                sides[s][2][1] = sides[s][1][0];
                sides[s][2][0] = temp[0];
                sides[s][1][0] = temp[1];
            }
        }

        String print() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    sb.append(sides[0][i][j]);

                sb.append("\n");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            Cube cube = new Cube();

            for (int i = 0; i < n; i++)
                cube.rotate(str[i].charAt(0), str[i].charAt(1));

            bw.write(cube.print());
        }

        br.close();
        bw.close();
    }
}
