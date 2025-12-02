package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ_11497_통나무_건너뛰기 {

  // 12:30
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    BOJ_11497_통나무_건너뛰기 solution = new BOJ_11497_통나무_건너뛰기();

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int answer = solution.solution(arr, N);
      sb.append(answer).append("\n");
    }

    System.out.println(sb);

  }

  public int solution(int[] arr, int n) {
    if (n == 1) return 0;

    Arrays.sort(arr);

    int maxHeight = Integer.MIN_VALUE;

    int right = n - 1;
    maxHeight = Math.max(maxHeight, arr[right] - arr[right - 1]);
    right -= 1;
    while (right - 2 >= 0) {
      maxHeight = Math.max(maxHeight, arr[right] - arr[right - 2]);
      right = right - 2;
    }

    right = n - 1;
    while (right - 2 >= 0) {
      maxHeight = Math.max(maxHeight, arr[right] - arr[right - 2]);
      right = right - 2;
    }

    maxHeight = Math.max(maxHeight, arr[1] - arr[0]);

    return maxHeight;
  }

}