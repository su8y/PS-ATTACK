package solved.ac;

import java.io.*;
import java.util.*;

// 20:01
class BOJ_15903_카드_합체_놀이 {
  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      var tokens = new StringTokenizer(reader.readLine());
      int N = Integer.parseInt(tokens.nextToken());
      int C = Integer.parseInt(tokens.nextToken());

      tokens = new StringTokenizer(reader.readLine());

      PriorityQueue<Long> pq = new PriorityQueue<>();
      for (int i = 0; i < N; i++) {
        pq.offer(Long.parseLong(tokens.nextToken()));
      }

      while (C-- > 0) {
        long x = pq.poll();
        long y = pq.poll();
        pq.offer(x + y);
        pq.offer(x + y);
      }
      long answer = 0L;
      while (!pq.isEmpty()) {
        answer += pq.poll();
      }
      System.out.println(answer);

    } catch (Exception e) {

    }
  }
}
