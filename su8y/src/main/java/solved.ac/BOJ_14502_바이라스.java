package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2 바이러스 1 벽 0 안전지대
 * 0의 안전지대를 최대화 할수있는 지역을 구한다.
 */
public class BOJ_14502_바이라스 {
    static int resultCount;
    static int[][] dirs = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    private static int n;
    private static int m;
    private static int[][] arr;

    private static void dfs(int deps) {
        if (deps == 3) {
            resultCount = Math.max(resultCount, bfs());
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) continue;
                arr[i][j] = 1;
                dfs(deps + 1);
                arr[i][j] = 0;
            }
        }
    }

    private static int bfs() {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 2) continue;
                q.add(new Pair(i, j));
            }
        }

        int[][] copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextY = dirs[k][0] + poll.y;
                int nextX = dirs[k][1] + poll.x;
                if (isValid(nextY, nextX) && copyArr[nextY][nextX] == 0) {
                    copyArr[nextY][nextX] = 2;
                    q.add(new Pair(nextY, nextX));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int totalCount = 0;
        arr = new int[n][m];

        input(reader, n, m, totalCount);
        dfs(0);

        System.out.println(resultCount);
        // 3개의 공간에 남김없이 놔둬야 된다. 그걸 하기 위해서는 어떻게 해야될까?
        // 우선 3가지 단계로 나눈다.
        // 3개의 벽을 설치한다.
        // 바이러스를 퍼뜨린다 . 바이러스를 셀때 남은 구역수를 줄일수가 있다.
        // 남은 구역을 센다.


    }

    private static void input(BufferedReader reader, int N, int M, int totalCount) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int e = Integer.parseInt(st.nextToken());
                if (e == 0) totalCount++;
                arr[i][j] = e;
            }
        }
    }

    private static class Pair {
        public int y;
        public int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
