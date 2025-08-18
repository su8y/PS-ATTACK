/*
 * 문제: 백준 13334번 - 철로 (https://www.acmicpc.net/problem/13334)
 * 문제 풀이
 *  집과 사무실의 위치를 모두 선분 위에 표시하고 정렬.
 *  슬라이딩 윈도우를 사용하여 일정 범위 내의 선분 개수의 최대값을 구함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13334_철로_1 {
    // public class Main {
    private static class Point {
        int id, x;

        public Point(int id, int x) {
            this.id = id;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> line = new ArrayList<>(n << 1);
        int[] isIncluded = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());

            line.add(new Point(i, h));
            line.add(new Point(i, o));
        }

        line.sort(Comparator.comparingInt(a -> a.x));

        int d = Integer.parseInt(br.readLine());
        int pos = 0;
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < line.size(); i++) {
            long end = line.get(i).x + d;

            while (pos < line.size() && line.get(pos).x <= end) {
                if (++isIncluded[line.get(pos++).id] == 2) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);

            if (end >= 100_000_000) {
                break;
            } else if (isIncluded[line.get(i).id]-- == 2) {
                cnt--;
            }
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
