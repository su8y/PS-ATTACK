/*
 * 문제: 백준 2304번 - 창고 다각형 (https://www.acmicpc.net/problem/2304)
 * 문제 풀이
 *  입력받은 기둥들을 정렬하고 왼쪽에서 오른쪽으로, 오른쪽에서 왼쪽으로 각각 최대 높이 기둥을 갱신하면서
 *  현재 기둥이 이전 최대 높이보다 높으면 스택에 추가.
 *  스택에서 기둥들을 하나씩 꺼내면서 면적을 계산.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
    // public class Main {
    static class Pillar {
        int l, r, h;

        public Pillar(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pillar[] pillars = new Pillar[n];
        Stack<Pillar> left = new Stack<>();
        Stack<Pillar> right = new Stack<>();
        int max = 0;
        int size = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            pillars[i] = new Pillar(l, l + 1, h);
        }

        Arrays.sort(pillars, Comparator.comparingInt(a -> a.l));

        for (int i = 0; i < n; i++) {
            if (max < pillars[i].h) {
                max = pillars[i].h;
                left.add(pillars[i]);
            }
        }

        max = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (max < pillars[i].h) {
                max = pillars[i].h;
                right.add(pillars[i]);
            }
        }

        Pillar leftPrev = left.pop();
        Pillar rightPrev = right.pop();
        size += (rightPrev.r - leftPrev.l) * max;

        while (!left.isEmpty()) {
            Pillar pillar = left.pop();

            size += (leftPrev.l - pillar.l) * pillar.h;
            leftPrev = pillar;
        }

        while (!right.isEmpty()) {
            Pillar pillar = right.pop();

            size += (pillar.r - rightPrev.r) * pillar.h;
            rightPrev = pillar;
        }

        bw.write(Integer.toString(size));
        br.close();
        bw.close();
    }
}
