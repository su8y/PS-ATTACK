/*
 * 문제: 백준 28707번 - 배열 정렬 (https://www.acmicpc.net/problem/28707)
 * 문제 풀이
 *  배열의 순서를 비트마스크를로 압축하여 하나의 정수로 표현.
 *  다익스트라를 이용하여 배열을 정렬하는 최소 비용을 구함.
 *  현재 상태가 정렬된 상태라면 최소 비용을 출력하고 아니면 가능한 모든 교환을 수행하여 새로운 상태를 생성.
 *  새로운 상태가 기존 상태보다 더 작은 비용을 가진다면 우선순위 큐에 넣어 다익스트라를 수행.
 *
 * 시간 복잡도: O(m log n!)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_28707_배열정렬 {
    // public class Main {
    private static int n;
    private static int[] arr;

    private static boolean isSorted(int bitMask) {
        int mask = (1 << 3) - 1;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            int idx = bitMask & mask;

            if (arr[idx] < prev) {
                return false;
            }

            prev = arr[idx];
            bitMask >>= 3;
        }

        return true;
    }

    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class Item {
        int v, w;

        public Item(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int bitMask = 0;
        Edge[] edges = new Edge[m];
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        Map<Integer, Integer> dist = new HashMap<>();
        int result = -1;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(l, r, c);
        }

        for (int i = 0; i < n; i++) {
            bitMask |= i << (i * 3);
        }

        pq.offer(new Item(bitMask, 0));
        dist.put(bitMask, 0);

        while (!pq.isEmpty()) {
            Item item = pq.poll();

            if (item.w > dist.get(item.v)) {
                continue;
            } else if (isSorted(item.v)) {
                result = item.w;
                break;
            }

            for (Edge edge : edges) {
                int mask = (1 << 3) - 1;
                int u = edge.u * 3;
                int v = edge.v * 3;
                int l = item.v & (mask << u);
                int r = item.v & (mask << v);
                int nw = item.w + edge.w;

                bitMask = item.v ^ l ^ r;
                l = l >> u << v;
                r = r >> v << u;
                bitMask |= l | r;

                if (dist.getOrDefault(bitMask, Integer.MAX_VALUE) > nw) {
                    pq.offer(new Item(bitMask, nw));
                    dist.put(bitMask, nw);
                }
            }
        }

        bw.write(Integer.toString(result));
        br.close();
        bw.close();
    }
}
