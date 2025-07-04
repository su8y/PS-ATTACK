/*
 * 문제: 백준 20055번 - 컨베이어 벨트 위의 로봇 (https://www.acmicpc.net/problem/20055)
 *
 * 시간 복잡도: O(n * s) - s: 내구도의 총합
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] belt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] robot = new boolean[n];
        int step = 0;
        int cnt = 0;

        while (cnt < k) {
            step++;

            int temp = belt[belt.length - 1];

            for (int i = belt.length - 1; i > 0; i--)
                belt[i] = belt[i - 1];

            belt[0] = temp;
            robot[n - 1] = false;
            robot[n - 2] = false;

            for (int i = n - 3; i >= 0; i--) {
                if (!robot[i])
                    continue;

                if (belt[i + 2] > 0 && !robot[i + 2]) {
                    if (--belt[i + 2] == 0)
                        cnt++;

                    robot[i + 2] = true;
                } else {
                    robot[i + 1] = true;
                }

                robot[i] = false;
            }

            if (belt[0] > 0) {
                if (--belt[0] == 0)
                    cnt++;

                robot[0] = true;
            }
        }

        bw.write(Integer.toString(step));
        br.close();
        bw.close();
    }
}
