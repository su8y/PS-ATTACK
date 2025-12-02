package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의_이동 {
    static int N, M;
    static Dot end;
    static int[][] matrix = new int[301][301];
    static int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            // matrix intial
            for (int i1 = 0; i1 < N; i1++) Arrays.fill(matrix[i1], 0);
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Dot start = new Dot(input[0], input[1]);
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            end = new Dot(input[0], input[1]);

            Queue<Dot> q = new LinkedList();
            q.offer(start);
            matrix[start.y][start.x] = 1;
            while (!q.isEmpty()) {
                Dot cur = q.poll();
                int hereX = cur.x;
                int hereY = cur.y;
                int hereCost = matrix[hereY][hereX];
                if (hereX == end.x && hereY == end.y) {
                    //출력
                    bw.write(String.valueOf(matrix[hereY][hereX] - 1));
                    bw.write("\n");
                    bw.flush();
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nextY = cur.y + dirs[j][0];
                    int nextX = cur.x + dirs[j][1];
                    if (isVaild(nextX, nextY) && matrix[nextY][nextX] == 0) {
                        matrix[nextY][nextX] = hereCost + 1;
                        q.offer(new Dot(nextX, nextY));
                    }
                }
            }
        }
        br.close();
        bw.close();
    }

    private static boolean isVaild(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}