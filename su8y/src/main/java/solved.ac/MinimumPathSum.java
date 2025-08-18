package solved.ac;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPathSum {
    private static class Pair<First, Second> {
        public First first;
        public Second second;

        public Pair(First first, Second second) {
            this.first = first;
            this.second = second;
        }
    }
    //Dandelions
    final static int[] x = {1, 0};
    final static int[] y = {0, 1};

    public static int minPathSum(int[][] grid) {
        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> pq = new PriorityQueue<>();
//        PriorityQueue<AbstractMap.SimpleEntry<AbstractMap.SimpleEntry<Integer, Integer>, Integer>> pq = new PriorityQueue<>();

        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] column : dist) {
            Arrays.fill(column, 9999);
        }

        pq.offer(new Pair(new Pair(0, 0), grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int herex = pq.peek().first.first;
            int herey = pq.peek().first.second;
            int cost = pq.peek().second;
            pq.poll();

            if (dist[herey][herex] < cost) continue;

            for (int i = 0; i < 2; i++) {
                int dx = herex + x[i];
                int dy = herey + y[i];
                if (dx >= 0 && dx < dist[0].length && dy >= 0 && dy < dist.length) {

                    int nextDist = cost + grid[dy][dx];

                    if (nextDist < dist[dy][dx]) {
                        pq.offer(new Pair(new Pair(dx, dy), nextDist));
                        dist[dy][dx] = nextDist;
                    }
                }
            }

        }


        return dist[dist.length - 1][dist[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(
//                minPathSum(new int[][]{{1, 3,1},{1,5,1}, {4,2,1}})
                minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}})

        );
    }
}
