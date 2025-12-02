/*
 * 문제: 백준 1736번 - 쓰레기 치우기 (https://www.acmicpc.net/problem/1736)
 * 문제 풀이
 * 	쓰레기를 수거하기 위해 방을 왼쪽에서 오른쪽으로 위에서 아래 순으로 검사.
 * 	1차원 배열에 로봇의 위치를 기록, 2차원 배열이 아니라 1차원 배열로 한 이유는 위쪽에서 사용한 로봇 위치 그래도 아래쪽에서 사용하기 때문.
 * 	예를 들어 방의 크기가 (n,m)이고 쓰레기가 (1,2), (2,2)에 있을 때
 * 	n=1일 때 로봇이 (1,2) 위치에 있는 쓰레기를 수거하려고 (1,2) 위치고 갔을 것이고
 * 	n=2일 때 (1,2) 위치에 있는 로봇을 그대로 n 값만 바꿔 (2,2) 위치로 사용하면 됨.
 * 	한 행에서 몇 개의 로봇이 어느 위치에 있는지만 알면 되기 때문에 1차원 배열 사용.
 * 	방을 검사하다 쓰레기를 발견하면 쓰레기 왼쪽에 있는 로봇 중 가장 가까운 로봇을 부르고 로봇이 없다면 로봇 개수를 1증가시키고 배열에 위치를 기록함.
 *
 * 시간 복잡도: O(n * m)
 */

package baekjoon.workbook0.chapter1.section7;

import java.io.*;
import java.util.stream.*;

public class BOJ_1736_쓰레기치우기 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int room[][] = new int[n][m];
        int robotPosition[] = new int[m];
        int robot = 0;

        for (int i = 0; i < n; i++)
            room[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            int nearRobot = -1;

            for (int j = 0; j < m; j++) {
                if (robotPosition[j] != 0)
                    nearRobot = j;

                if (room[i][j] == 1) {
                    if (nearRobot == -1)
                        robot++;
                    else
                        robotPosition[nearRobot]--;

                    robotPosition[j]++;
                    nearRobot = j;
                }
            }
        }

        bw.write(Integer.toString(robot));
        br.close();
        bw.close();
    }
}
