package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916 {
    private static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    static List<List<Pair>> adj;
    private static int v_c;
    private static int e_c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v_c = Integer.parseInt(br.readLine());
        e_c = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= v_c; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e_c; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Pair(cost, end));
        }
        st = new StringTokenizer(br.readLine());
        int startVertax = Integer.parseInt(st.nextToken());
        int endVertax = Integer.parseInt(st.nextToken());
        int[] dist = dij(startVertax);
        System.out.println(dist[endVertax]);
    }

    public static int[] dij(int startVertax) {
        int[] dist = new int[v_c + 1];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startVertax] = 0;
        q.offer(new Pair(0, startVertax));

        while (!q.isEmpty()) {
            int here = (int) q.peek().second;
            int cost = (int) q.peek().first;
            q.poll();

            if (dist[here] != cost) continue;

            for (Pair i : adj.get(here)) {
                int there = (int) i.second;
                int thereCost = (int) i.first;
                if (dist[there] > thereCost + cost) {
                    dist[there] = thereCost + cost;
                    q.offer(new Pair(thereCost + cost, there));
                }
            }
        }

        return dist;
    }
}
