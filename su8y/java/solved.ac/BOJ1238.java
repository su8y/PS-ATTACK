package solved.ac;

import java.io.*;
import java.util.*;

public class BOJ1238 {
    private static class Pair{
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // 단방향 간선을 반대로 저장하게 되어 마찬가지로 2번노드를 목적지 노드가 아닌 출발지 노드로 바꿀수있는 꼼수가 있다.
    static List<List<Pair>> adj, reverse_adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // list 초기화
        adj = new ArrayList<>();
        reverse_adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            reverse_adj.add(new ArrayList<>());
        }

        // list 초기화 2
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Pair(dist, end));
            reverse_adj.get(end).add(new Pair(dist, start));
        }
        int[] dist1 = dij(X, N, adj);
        int[] dist2 = dij(X, N, reverse_adj);

        int ans = 0;
        for (int i = 0; i < dist1.length; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);


        br.close();
    }

    public static int[] dij(int start, int size, List<List<Pair>> adj) {
        int result = 0;
        int[] dist = new int[size + 1];

        //dist 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>();
        dist[start] = 0;
        q.offer(new Pair(0, start));

        while (!q.isEmpty()) {
            int cost = (int) q.peek().first;
            int here = (int) q.peek().second;
            q.poll();
            // 3 위배 작성 요망 방금 꺼낸것이 dist[here]과 다르면 한번 완화한 간선이다.
            if (dist[here] != cost) continue;

            for (Pair i : adj.get(here)) {
                int there = (int) i.second;
                int nextCost = (int) i.first;
                if (dist[there] > cost + nextCost) {
                    dist[there] = cost + nextCost;
                    q.offer(new Pair(nextCost + cost, there));
                }
            }
        }
        for (int i = 0; i < size + 1; i++) {
            if (dist[i] > result) result = dist[i];
        }


        return dist;
    }
}
