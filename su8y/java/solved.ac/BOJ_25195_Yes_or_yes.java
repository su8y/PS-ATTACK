package solved.ac;

import java.io.*;
import java.util.*;

public class BOJ_25195_Yes_or_yes {
  private static final int MAX_LEN = 100001;
  private static final boolean[] bare = new boolean[MAX_LEN];
  private static List<List<Integer>> graph;

  private static boolean travelFromOne() {
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);

    while (!q.isEmpty()) {
      int curr = q.poll();

      if (bare[curr]) continue; // 아이돌 곰이 서있는 경우
      if (graph.get(curr).isEmpty()) return true; // 아이돌 곰이 서있지 않고 더 이상 갈수 없는 경우 == 종료 시점

      for (Integer next : graph.get(curr)) {
        q.offer(next);
      }
    }

    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(start).add(end);
    }
    int K = Integer.parseInt(br.readLine());
    int[] barePosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i = 0; i < K; i++) {
      bare[barePosition[i]] = true;
    }

    if (travelFromOne()) {
      System.out.println("yes");
    } else {
      System.out.println("Yes");
    }

  }
}