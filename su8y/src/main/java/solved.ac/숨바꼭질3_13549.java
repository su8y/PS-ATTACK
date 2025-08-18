package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {
    static int K, N, M, T;
    /**
     * 1. 시작점 start를 우선순위큐에 넣는다.
     * 2. 우선순위 큐에서 정점 x를뺀다.
     * 3. dist[x] != 현재빼낸값 이라면 4번을 생략한다.
     * 4. 정점 x에 연결된 각각의 정점 i에 대해 ,
     * dist[i] = dist[i] > dist[x] + 간선의 길이
     * (dist[i],i) 를우선순위 큐에 넣는다.
     * 5. 우선순위 큐에 원소가 남아 있다면 2번으로 돌아간다.
     */
    static int[] cache = new int[100001];

    public static int solve(int sec, int cur, int end) {
        Arrays.fill(cache, 999999);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Pair(cur, 0));
        cache[cur] = 0;
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int hereNode = poll.node;
            int hereDist = poll.dist;

            if (hereDist != cache[hereNode]) continue;
            int there = hereNode + 1;
            if (there < 100001 && cache[there] > hereDist + 1) {
                pq.add(new Pair(there, hereDist + 1));
                cache[there] = hereDist + 1;
            }
            there = hereNode - 1;
            if (there >= 0 && cache[hereNode - 1] > hereDist + 1) {
                pq.add(new Pair(hereNode - 1, hereDist + 1));
                cache[there] = hereDist + 1;
            }
            there = hereNode * 2;
            if (there >= 0 && there < 100001 && cache[hereNode * 2] > hereDist) {
                pq.add(new Pair(there, hereDist));
                cache[there] = hereDist;
            }
        }
        return cache[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int solve = solve(0, N, K);
        bw.write(solve + "\n");

        bw.close();
        br.close();
    }

    private static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}