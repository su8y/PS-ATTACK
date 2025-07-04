/*
 * 문제: 백준 4471번 - The Navi-Computer is Down! (https://www.acmicpc.net/problem/4471)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4471_TheNaviComputerisDown {
    // public class Main {
    private static class Star {
        String name;
        double x, y, z;

        public Star(String name, double x, double y, double z) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Star[] stars = new Star[2];

            for (int j = 0; j < 2; j++) {
                String name = br.readLine();
                StringTokenizer st = new StringTokenizer(br.readLine());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                double z = Double.parseDouble(st.nextToken());

                stars[j] = new Star(name, x, y, z);
            }

            double x = stars[1].x - stars[0].x;
            double y = stars[1].y - stars[0].y;
            double z = stars[1].z - stars[0].z;
            double root = Math.sqrt(x * x + y * y + z * z);

            sb.append(String.format("%s to %s: %.2f\n", stars[0].name, stars[1].name, root));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
