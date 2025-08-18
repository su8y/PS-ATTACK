/*
 * 문제: 백준 7579번 - 앱 (https://www.acmicpc.net/problem/7579)
 * 문제 풀이
 *  DFS를 이용한 분기 한정법(Branch-and-Bound)으로 최적해를 찾음.
 *  Branch-and-Bound는 최적화 문제를 해결하기 위한 기법으로 상태 공간 트리를 사용하여 탐색하면서 불필요한 경로를 제거하여 최적해를 찾는 방법.
 *  문제를 더 작은 문제로 나누어 탐색. 이 문제에서는 현재 앱을 비활성화하는 경우와 활성화하는 경우로 분기.
 *  현재 노드에서 유망성 검사를 해서 더 탐색할 가치가 있는지 판단. 유망하지 않다면(최적해를 찾을 가능성이 없다면) 탐색을 중단.
 *  이를 통해 불필요한 탐색을 줄여 실행 속도를 향상시킬 수 있음.
 *  탐색을 진행하면서 현재까지의 최적해를 갱신.
 *
 * 시간 복잡도: O(2^n)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_7579_앱_2 {
    // public class Main {
    private static int n, m;
    private static Item[] items;
    private static int maxProfit = 0;

    private static boolean promising(int depth, int weight, int profit) {
        if (depth == n || weight == m) {
            return false;
        }

        while (depth < n && weight + items[depth].w <= m) {
            weight += items[depth].w;
            profit += items[depth].v;
            depth++;
        }

        if (depth < n) {
            profit += (int) ((m - weight) * items[depth].ratio);
        }

        return profit > maxProfit;
    }

    private static void knapsack(int depth, int weight, int profit) {
        if (weight > m) {
            return;
        } else if (profit > maxProfit) {
            maxProfit = profit;
        }

        if (promising(++depth, weight, profit)) {
            knapsack(depth, weight + items[depth].w, profit + items[depth].v);
            knapsack(depth, weight, profit);
        }
    }

    private static class Item {
        int w, v;
        double ratio;

        public Item(int w) {
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int wSum = 0;
        int vSum = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        items = new Item[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            items[i] = new Item(Integer.parseInt(st.nextToken()));
            wSum += items[i].w;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            items[i].v = Integer.parseInt(st.nextToken());
            items[i].ratio = (double) items[i].v / items[i].w;
            vSum += items[i].v;
        }

        m = wSum - m;
        Arrays.sort(items, Comparator.comparingDouble(a -> -a.ratio));
        knapsack(-1, 0, 0);
        bw.write(Integer.toString(vSum - maxProfit));
        br.close();
        bw.close();
    }
}
