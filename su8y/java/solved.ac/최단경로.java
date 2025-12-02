package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 최단경로 {
    public static List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] inputs = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int v = inputs[0];
        int e = inputs[1];

        int startV = Integer.parseInt(br.readLine());

        for (int i = 0; i < v + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            inputs = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            int a = inputs[0];
            int b = inputs[1];
            int w = inputs[2];

            adj.get(a).add(new Pair<>(b, w));

        }

        int[] dist = dijstra(startV, v);
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }


    }

    private static int[] dijstra(int src, int v) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int here = (int) pq.peek().getFirst();
            int cost = (int) pq.peek().getSecond();
            pq.poll();

            if (cost > dist[here]) continue;

            for (int i = 0; i < adj.get(here).size(); i++) {
                int there = adj.get(here).get(i).getFirst();
                int nextDist = cost + adj.get(here).get(i).getSecond();

                if (dist[there] > nextDist) {
                    pq.offer(new Pair(there, nextDist));
                    dist[there] = nextDist;
                }
            }
        }

        return dist;
    }

    private static class Pair<T, U> implements Comparable<Pair> {
        T first;
        U second;

        public Pair(T v, U u) {
            this.first = v;
            this.second = u;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) this.second - (int) o.getSecond();
        }
    }
}
