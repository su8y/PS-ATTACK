/*
 * 문제: 백준 1202번 - 보석 도둑 (https://www.acmicpc.net/problem/1202)
 * 문제 풀이
 *  가방의 무게 제한보다 가벼운 보석 중에서 가치가 가장 높은 보석을 선택.
 *  보석과 가방을 무게를 기준으로 오름차순으로 정렬.
 *  가방의 무게 제한보다 가벼운 보석을 우선순위 큐(보석의 가치 기준)에 삽입.
 *  가방의 무게 제한보다 무거운 보석이 나오거나 모든 보석을 큐에 삽입했다면 큐에서 가치가 가장 높은 보석을 빼서 가방에 담음.
 *  모든 가방에 대해 반복해서 가치의 총합을 구함.
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {
    // public class Main {
    private static class Jewel {
        int w, v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[n];
        int[] bags = new int[k];
        PriorityQueue<Jewel> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a.v));
        int pos = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(m, v);
        }

        for (int i = 0; i < k; i++)
            bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(jewels, Comparator.comparingInt(a -> a.w));
        Arrays.sort(bags);

        for (int bag : bags) {
            while (pos < n && bag >= jewels[pos].w)
                queue.offer(jewels[pos++]);

            if (!queue.isEmpty())
                result += queue.poll().v;
        }

        bw.write(Long.toString(result));
        br.close();
        bw.close();
    }
}
