package solved.ac;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    boolean[] visited;
    int[][] graph;
    int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        System.out.println(N);
    }

    void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        //시작 정점을 큐에 넣는다.
        q.offer(start);

        // 큐가 비어있지않다면
        while (!q.isEmpty()) {
            int x = q.peek();
            q.poll();

            System.out.println(x + " 번 정점 방문 완료 !");

            for (int i : graph[x]) {
                if (!visited[x]) {
                    dist[i] = dist[x] + 1;
                    q.offer(i);
                    visited[i] = true;
                }

            }
        }

    }

}