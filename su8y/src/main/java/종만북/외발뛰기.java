package 종만북;

public class 외발뛰기 {
    static int n = 5;
    static int[][] board = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2},
            {3, 2, 1, 1, 1}
    };
    static int[][] cache = {
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
    };

    public static void main(String[] args) {
        int result = solve2(0, 0);
        System.out.println(result);
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                System.out.printf("%d ", cache[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean solve1(int y, int x) {
        if (y >= n || x >= n) return false;
        if (y == n - 1 && x == n - 1) return true;

        int jumpSize = board[y][x];
        return solve1(y + jumpSize, x) || solve1(y, x + jumpSize);
    }

    private static int solve2(int y, int x) {
        if (y >= n || x >= n) return 0;
        if (y == n - 1 && x == n - 1) return 1;
        if (cache[y][x] != -1) return cache[y][x];
        int jumpSize = board[y][x];
        return cache[y][x] = (solve2(y + jumpSize, x) | solve2(y, x + jumpSize));
    }
}
