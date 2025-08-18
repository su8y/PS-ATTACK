/*
 * 문제: 백준 17387번 - 선분 교차 2 (https://www.acmicpc.net/problem/17387)
 * 문제 풀이
 *  두 선분이 서로 다른 방향에서 교차하는지 CCW(Counter Clockwise) 연산을 통해 판별.
 *  CCW는 세 점이 이루는 방향을 판별하는 알고리즘으로 점 A, B, C가 주어졌을 때,
 *  점 A → B → C가 반시계 방향인지, 시계 방향인지, 일직선상에 있는지를 판단하는 데 사용됨.
 *  벡터 AB 와 AC의 외적(Cross Product)을 구하면 방향을 판별할 수 있음.
 *  외적을 구하는 공식은 cross = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)
 *  cross가 0보다 작으면 반시계 방향, 0보다 크면 시계 방향, 0이면 일직선을 이룸.
 *  CCW는 세 점이 이루는 방향을 판별하므로 두 선분의 교차 판단을 하기 위해서는 총 4번의 CCW 연산을 해야 함.
 *  선분 l1이 (p1 -> p2)이고 l2가 (p3 -> p4)일 때,
 *  CCW(p1, p2, p3) * CCW(p1, p2, p4) < 0 && CCW(p3, p4, p1) * CCW(p3, p4, p2) < 0이 되어야 교차한다고 판단.
 *  위의 경우 외에도 모든 선분이 일직선상에 있는 경우(CCW 값이 모두 0인 경우)도 처리해야 함.
 *  두 선분이 일직선상에서 겹치는지 min(p1, p2) <= max(p3, p4) && max(p1, xp) >= min(p3, p4) 연산을 통해 판단.
 *
 * 시간 복잡도: O(1)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17387_선분교차2 {
    // public class Main {
    private static int ccw(Pos a, Pos b, Pos c) {
        Pos ab = new Pos(b.x - a.x, b.y - a.y);
        Pos ac = new Pos(c.x - a.x, c.y - a.y);
        long cross = (long) ab.x * ac.y - (long) ac.x * ab.y;

        if (cross < 0) {
            return -1;
        } else if (cross > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Pos[][] lines = new Pos[2][2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                lines[i][j] = new Pos(x, y);
            }
        }

        int cross1 = ccw(lines[0][0], lines[0][1], lines[1][0]) * ccw(lines[0][0], lines[0][1], lines[1][1]);
        int cross2 = ccw(lines[1][0], lines[1][1], lines[0][0]) * ccw(lines[1][0], lines[1][1], lines[0][1]);

        if (cross1 + cross2 < 0
                || (cross1 == 0 && cross2 == 0 &&
                Math.min(lines[0][0].x, lines[0][1].x) <= Math.max(lines[1][0].x, lines[1][1].x) &&
                Math.max(lines[0][0].x, lines[0][1].x) >= Math.min(lines[1][0].x, lines[1][1].x) &&
                Math.min(lines[0][0].y, lines[0][1].y) <= Math.max(lines[1][0].y, lines[1][1].y) &&
                Math.max(lines[0][0].y, lines[0][1].y) >= Math.min(lines[1][0].y, lines[1][1].y))
        ) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}
