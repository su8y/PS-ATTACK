/*
 * 문제: 백준 1708번 - 볼록 껍질 (https://www.acmicpc.net/problem/1708)
 * 문제 풀이
 *  그레이엄 스캔(Graham Scan)을 사용하여 볼록 껍질(Convex Hull)을 구함.
 *  주어진 점들 중 가장 아래쪽(y가 같으면 가장 왼쪽) 점을 기준점으로 잡고 나머지 점들을 반시계 방향으로 정렬.
 *  정렬 시, CCW를 통해 두 점에 대해 기준점과의 외적을 계산하여 외적 값이 양수(반시계 방향)가 되도록 정렬.
 *  외적이 0일 경우(일직선상인 경우) 거리가 가까운 점을 먼저 정렬.
 *  정렬된 순서대로 점을 스택에 쌓으면서 스택에 쌓인 마지막 두 점과 현재 점을 CCW로 검사하여 외적 값이 양수일 때만 유지하고
 *  양수가 아니라면 스택의 마지막 점을 빼고 다시 외적 값을 구함.
 *  모든 점을 처리하고 스택에 남아있는 점의 개수가 볼록 껍질의 개수.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1708_볼록껍질 {
    // public class Main {
    private static Pos pivot;

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

    private static long getDist(Pos p) {
        long dx = pivot.x - p.x;
        long dy = pivot.y - p.y;

        return dx * dx + dy * dy;
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
        int n = Integer.parseInt(br.readLine());
        Pos[] points = new Pos[--n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Pos> stack = new Stack<>();

        pivot = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pos point = new Pos(x, y);

            if (y < pivot.y || (y == pivot.y && x <= pivot.x)) {
                points[i] = pivot;
                pivot = point;
            } else {
                points[i] = point;
            }
        }

        Arrays.sort(points, (a, b) -> {
            int cross = ccw(pivot, a, b);

            return cross == 0 ? Long.compare(getDist(a), getDist(b)) : -cross;
        });

        stack.push(pivot);
        stack.push(points[0]);

        for (int i = 1; i < n; i++) {
            while (stack.size() > 1) {
                int cross = ccw(stack.get(stack.size() - 2), stack.peek(), points[i]);

                if (cross == 1) {
                    break;
                }

                stack.pop();
            }

            stack.push(points[i]);
        }

        bw.write(Integer.toString(stack.size()));
        br.close();
        bw.close();
    }
}
