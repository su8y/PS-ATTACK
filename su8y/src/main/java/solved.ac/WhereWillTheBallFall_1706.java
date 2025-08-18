package solved.ac;

/**
 * 우선 왼쪽 벽에 방향을 검사한 후(index) 1 이면 오른쪽벽(index+1) 을 검사한다.
 * 왼쪽벽이(index) -1 이면 (index)가 오른쪽벽이 되고 왼쪽벽은 (index-1)이 된다.
 * 만약 벽에 direction이 다르다면 막혀있는 것이기 때문에 -1를 리턴 해준다.
 */
public class WhereWillTheBallFall_1706 {
    private static int size;
    private static int yLen;
    private static int[][] graph;

    public int dfs(int index, int deps) {
        if (index < 0 || index >= size) return -1;
        if (deps == yLen) return index;

        int leftDir = graph[deps][index];
        int rightDir = 0;
        if (index + 1 < size)
            rightDir = graph[deps][index + 1];
        if (leftDir == -1 && index - 1 >= 0) {
            rightDir = leftDir;
            leftDir = graph[deps][index - 1];
        }
        if (leftDir != rightDir) return -1;
        return leftDir == 1 ?
                dfs(index + 1, deps + 1) :
                dfs(index - 1, deps + 1);
    }

    public int[] findBall(int[][] grid) {
        size = grid[0].length;
        yLen = grid.length;
        graph = grid.clone();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = dfs(i, 0);
        }
        return result;
    }
}
