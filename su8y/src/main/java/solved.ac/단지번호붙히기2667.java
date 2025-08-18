package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 단지번호붙히기2667 {


    private final static int[][] xy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //right // top// left //dwon
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {1, 0, -1, 0};
    private static int[][] graph;
    // [] y [] x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            if (split.length > n) throw new IllegalStateException("범위 오류");
            //input 입력 받기
            graph[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }

        PriorityQueue<Integer> integers = dfsAll();
        System.out.println(integers.size());
        while (!integers.isEmpty()) {
            System.out.println(integers.poll());
        }

    }

    private static PriorityQueue<Integer> dfsAll() {
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for (int y = 0; y < graph.length; ++y) {
            for (int x = 0; x < graph.length; ++x) {
                if (graph[y][x] == 1) {
                    int count = dfs(y, x, 1);
                    list.offer(count);
                }
            }
        }
        return list;
    }

    private static int dfs(int y, int x, int count) {
        graph[y][x] = 0;
        for (int i = 0; i < 4; ++i) {
            int vertical = dy[i] + y;
            int horizontal = dx[i] + x;
            if ((vertical >= 0 && vertical < graph.length) && (horizontal >= 0 && horizontal < graph.length)) {
                if (graph[vertical][horizontal] == 1) {
                    count = dfs(vertical, horizontal, count + 1);
                }
            }
        }

        return count;

    }

}
