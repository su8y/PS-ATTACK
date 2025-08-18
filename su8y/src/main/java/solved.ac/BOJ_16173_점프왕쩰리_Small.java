package solved.ac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 1. ‘쩰리’는 가로와 세로의 칸 수가 같은 정사각형의 구역 내부에서만 움직일 수 있다. ‘쩰리’가 정사각형 구역의 외부로 나가는 경우엔 바닥으로 떨어져 즉시 게임에서 패배하게 된다.
 * 2. ‘쩰리’의 출발점은 항상 정사각형의 가장 왼쪽, 가장 위의 칸이다. 다른 출발점에서는 출발하지 않는다.
 * 3. ‘쩰리’가 이동 가능한 방향은 오른쪽과 아래 뿐이다. 위쪽과 왼쪽으로는 이동할 수 없다.
 * 4. ‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리로 게임은 종료된다.
 * 5. ‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼이다. 칸에 쓰여 있는 수 초과나 그 미만으로 이동할 수 없다.
 */
public class BOJ_16173_점프왕쩰리_Small {
    private static final String WIN = "HaruHaru";
    private static final String LOSE = "Hing";

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var n = Integer.parseInt(br.readLine());
        var map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        var status = new BOJ_16173_점프왕쩰리_Small().bfs(map, n);
        bw.write(status ? WIN : LOSE);

        bw.close();
        br.close();
    }

    private boolean isEndGame(int n, int y, int x) {
        return y == n - 1 && x == n - 1;
    }

    private boolean isMovePossible(int n, int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    public boolean bfs(int[][] map, int n) {
        var queue = new LinkedList<Person>();
        queue.add(new Person(0, 0));

        while (!queue.isEmpty()) {
            Person curr = queue.poll();
            if (!isMovePossible(n, curr.y, curr.x)) continue;
            if (isEndGame(n, curr.y, curr.x)) return true;

            int step = map[curr.y][curr.x];

            if (step > 0) {
                queue.add(new Person(curr.y + step, curr.x));
                queue.add(new Person(curr.y, curr.x + step));
            }
        }
        return false;
    }

    class Person {
        public final int y;
        public final int x;

        Person(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
