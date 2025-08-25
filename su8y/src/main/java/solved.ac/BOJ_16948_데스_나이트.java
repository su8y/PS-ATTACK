package solved.ac;

import java.io.*;
import java.util.*;

// 4:15
public class BOJ_16948_데스_나이트 {

  private static int[][] directions = {
      {-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}
  };

  // (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
  public static void main(String[] args) throws IOException {
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      BOJ_16948_데스_나이트 main = new BOJ_16948_데스_나이트();
      int N = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int answer = main.solution(arr[0], arr[1], arr[2], arr[3], N);

      System.out.println(answer);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int solution(int x, int y, int x1, int y1, int n) {
    int[][] visited = new int[n][n];
    for (var row : visited) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(y, x, 0));
    visited[y][x] = 0;

    while (!q.isEmpty()) {
      Node curr = q.poll();
      if (curr.y == y1 && curr.x == x1) {
        return curr.step;
      }

      for (var direction : directions) {
        int ny = curr.y + direction[1];
        int nx = curr.x + direction[0];
        if (this.isOut(ny, nx, n) || visited[ny][nx] <= curr.step + 1) continue;

        q.offer(new Node(ny, nx, curr.step + 1));
        visited[ny][nx] = curr.step + 1;
      }

    }
    return -1;
  }

  private boolean isOut(int y, int x, int n) {
    return y < 0 || y >= n || x < 0 || x >= n;
  }

  class Node {

    public int y;
    public int x;
    public int step;

    public Node(int y, int x, int step) {
      this.y = y;
      this.x = x;
      this.step = step;
    }

    @Override
    public String toString() {
      return y + " " + x;
    }
  }

}
