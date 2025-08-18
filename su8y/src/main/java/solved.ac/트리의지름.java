package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class 트리의지름 {
    static int ans = 0;
    static int max = 0;
    static int[] visited;
    static int dist, n, farthestNode;
    private static List<List<Pair>> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pq = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());

//        Arrays.fill(indegree, 99);
        for (int i = 0; i <= n; i++) {
            pq.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            while (true) {
//                st = new StringTokenizer(br.readLine());
                String input;
                if ((input = st.nextToken()).equals("-1"))
                    break;
                int v = Integer.parseInt(input);
                int c = Integer.parseInt(st.nextToken());

                pq.get(target).add(new Pair(v, c));
            }
        }
        visited = new int[pq.size() + 1];
        visited[1] = 1;
        dfs(1, 0);
        visited = new int[n + 1];

        dist = 0;
        visited[farthestNode] = 1;
        dfs(farthestNode, 0);
        System.out.println(dist);


    }

    private static void dfs(int x, int distSum) {
        if (dist < distSum) {
            dist = distSum;
            farthestNode = x;
        }
        for (Pair next : pq.get(x)) {
            if (visited[next.x] == 1) continue;
            visited[next.x] = 1;
            dfs(next.x, distSum + next.y);
        }
    }

    private static class Pair implements Comparator<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.x - o2.x;
        }
    }
}
/*
* package korsua.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class 시간초과트리의지름 {
    static int ans = 0;
    static int max = 0;

    private static List<List<Pair>> pq;

    static class Pair implements Comparator<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.x - o2.x;
        }
    }

    static int[] visited;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pq = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
//        Arrays.fill(indegree, 99);
        for (int i = 0; i <= n; i++) {
            pq.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            while (true) {
//                st = new StringTokenizer(br.readLine());
                String input;
                if ((input = st.nextToken()).equals("-1"))
                    break;
                int v = Integer.parseInt(input);
                int c = Integer.parseInt(st.nextToken());

                pq.get(target).add(new Pair(v, c));
                indegree[target]++;
            }
        }
        visited = new int[pq.size() + 1];
        for (int i = 0; i <= n; i++) {
            if (indegree[i] == 1) {
                visited[i] = 1;
                bt(i);
                visited[i] = 0;
            }
        }
        System.out.println(max);
    }

    private static void bt(int x) {
        max = Math.max(ans,max);
        for (int i = 0; i < pq.get(x).size(); i++) {
            int there = pq.get(x).get(i).x;
            int thereCost = pq.get(x).get(i).y;
            if(visited[there] == 0) {
                visited[there] = 1;
                ans += thereCost;
                bt(there);
                ans -= thereCost;
                visited[there] = 0;
            }
        }
    }
}
* */
