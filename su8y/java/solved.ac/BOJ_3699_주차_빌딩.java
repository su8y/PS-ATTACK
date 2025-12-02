package solved.ac;

import java.io.*;
import java.util.Arrays;

public class BOJ_3699_주차_빌딩 {
    private final static int E_TIME = 10;
    private final static int C_TIME = 5;
    private static int[] idxByFloor;
    private static int[][] map;
    private static int f;
    private static int w;
    private static int maxIdx;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");

            f = Integer.parseInt(s[0]);
            w = Integer.parseInt(s[1]);
            maxIdx = -1;
            map = new int[f][w];

            for (int i = 0; i < f; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    int v = Integer.parseInt(input[j]);
                    map[i][j] = v;
                    maxIdx = Math.max(v, maxIdx);
                }
            }

            // process
            idxByFloor = new int[f];
            Arrays.fill(idxByFloor, 0);

            int time = 0;
            for (int i = 1; i <= maxIdx; i++) {
                time += process(i);

            }
            bw.write(time + "\n");

        }

        bw.close();
        br.close();
    }

    private static int process(int target) {

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] != target) {
                    continue;
                }
                int lc = 1, rc = 1;

                while ((idxByFloor[i] + rc) % w != j) {
                    rc++;
                }
                while ((idxByFloor[i] - lc + w) % w != j) {
                    lc++;
                }
                int move = Math.min(lc, rc);

                if (j == idxByFloor[i]) {
                    move = 0;
                }

                idxByFloor[i] = j; // setting
                return ((E_TIME * i) * 2) + (move * C_TIME);
            }
        }

        return 0;
    }
}