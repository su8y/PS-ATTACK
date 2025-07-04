/*
 * 문제: 백준 3687번 - 성냥개비 (https://www.acmicpc.net/problem/3687)
 * 문제 풀이
 *  성냥개비로 최소값을 만들 때는 많은 성냥개비로 작은 수를 만들어야 함.
 *  가장 많은 성냥개비를 사용하는 수는 8이고 만들 수 있는 가장 작은 수는 0임.
 *  이 둘을 비교하여 수를 만들었을 때 더 작은 수를 메모이제이션.
 *  성냥개비로 최대값을 만들 때는 적은 성냥개비로 수를 만들어 함.
 *  가장 적은 성냥개비로 만들 수 있는 수는 1임.
 *  성냥개비로 최대한 1을 많이 만들면 그 수가 가장 큰 수.
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;

public class BOJ_3687_성냥개비 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String[] min = new String[101];
        String[] max = new String[101];

        min[1] = min[6] = "0";
        min[2] = max[2] = "1";
        min[3] = max[3] = "7";
        min[4] = "4";
        min[5] = "2";
        min[7] = "8";

        for (int i = 4; i < 8; i++)
            max[i] = max[i - 2] + max[2];

        for (int i = 8; i <= 100; i++) {
            String a = min[6] + min[i - 6];
            String b = min[7] + min[i - 7];

            min[i] = Long.parseLong("1" + a) < Long.parseLong("1" + b) ? a : b;
            max[i] = max[i - 2] + max[2];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String m;

            if (n == 6) {
                m = "6";
            } else if (n < 8) {
                m = min[n];
            } else {
                m = "6" + min[n - 6];

                for (int i : new int[]{2, 3, 4, 5, 7}) {
                    String num = min[i] + min[n - i];

                    if (Long.parseLong(m) > Long.parseLong(num))
                        m = num;
                }
            }

            bw.write(m + " " + max[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
