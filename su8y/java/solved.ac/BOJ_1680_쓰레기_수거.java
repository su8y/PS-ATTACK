package solved.ac;

import java.io.*;
import java.util.*;

public class BOJ_1680_쓰레기_수거 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    BOJ_1680_쓰레기_수거 boj = new BOJ_1680_쓰레기_수거();

    while (T-- > 0) {
      String[] input = br.readLine().split(" ");
      int maximumCapacity = Integer.parseInt(input[0]);
      int N = Integer.parseInt(input[1]);
      List<Integer> weight = new ArrayList<>();
      List<Integer> distanceFormOrigin = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        String[] w_d = br.readLine().split(" ");
        distanceFormOrigin.add(Integer.parseInt(w_d[0]));
        weight.add(Integer.parseInt(w_d[1]));
      }

      int distance = boj.calcDistance(maximumCapacity, weight, distanceFormOrigin, N);
      sb.append(distance + "\n");
    }
    System.out.println(sb);
  }

  //  쓰레기의 양이 용량에 도달했을 때.
  //  그 지점의 쓰레기를 실었을 때 쓰레기차의 용량을 넘게 될 때.
  //  더 이상 쓰레기를 실을 지점이 없을 때.
  private int calcDistance(int maximumCapacity, List<Integer> weight, List<Integer> distanceFromOrigin, int n) {
    int totalDistance = 0;
    int capacity = 0;
    int lastIdx = -1;

    for (int i = 0; i < n; i++) {
      int trashWeight = weight.get(i);
      if (trashWeight == 0) continue;

      if (capacity + trashWeight > maximumCapacity) { // 최대 용량을 넘게 되었다면
        totalDistance += distanceFromOrigin.get(i) * 2;
        capacity = 0;
        lastIdx = -1;
      }

      capacity += trashWeight;
      lastIdx = i;

      if (capacity == maximumCapacity) {
        totalDistance += distanceFromOrigin.get(i) * 2;
        capacity = 0;
        lastIdx = -1;
      }
    }

    if (lastIdx != -1) {
      totalDistance += distanceFromOrigin.get(lastIdx) * 2;
    }

    return totalDistance;
  }
}