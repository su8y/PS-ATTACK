/*
 * 문제: 백준 14891번 - 톱니바퀴 (https://www.acmicpc.net/problem/14891)
 *
 * 시간 복잡도: O(k)
 */

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
    // public class Main {
    private static void turn(StringBuilder gear, int d) {
        if (d == 1) {
            gear.insert(0, gear.charAt(7));
            gear.deleteCharAt(8);
        } else {
            gear.append(gear.charAt(0));
            gear.deleteCharAt(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder[] gears = new StringBuilder[5];

        for (int i = 1; i < 5; i++)
            gears[i] = new StringBuilder(br.readLine());

        int k = Integer.parseInt(br.readLine());
        int sum = 0;

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int d = dir;
            StringBuilder[] newGears = new StringBuilder[5];

            newGears[g] = new StringBuilder(gears[g]);
            turn(newGears[g], d);

            for (int i = g - 1; i > 0; i--) {
                newGears[i] = new StringBuilder(gears[i]);

                if (d == 0)
                    continue;

                if (gears[i].charAt(2) == gears[i + 1].charAt(6))
                    d = 0;
                else
                    turn(newGears[i], d = -d);
            }

            d = dir;

            for (int i = g + 1; i < 5; i++) {
                newGears[i] = new StringBuilder(gears[i]);

                if (d == 0)
                    continue;

                if (gears[i].charAt(6) == gears[i - 1].charAt(2))
                    d = 0;
                else
                    turn(newGears[i], d = -d);
            }

            gears = newGears;
        }

        for (int i = 0; i < 4; i++) {
            int cog = gears[i + 1].charAt(0) == '1' ? 1 : 0;

            sum += cog * (1 << i);
        }

        bw.write(Integer.toString(sum));
        br.close();
        bw.close();
    }
}
