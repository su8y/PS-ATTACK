package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 요소카운트_쿼리_PrefixSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int[][] map = new int[300][300];
        int[][][] prefixSum = new int[301][301][11];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).limit(n).toArray();
        }

        // calc 2D prefixSum
        for (int nu = 1; nu <= 10; nu++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    prefixSum[i + 1][j + 1][nu] = prefixSum[i + 1][j][nu]
                            + prefixSum[i][j + 1][nu]
                            - prefixSum[i][j][nu]; // 중복값 빼주기
                    if (nu == map[i][j]) prefixSum[i + 1][j + 1][nu] += 1;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            // when
            int[] xyxy = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).limit(4).toArray();
            int y1 = xyxy[0], x1 = xyxy[1], y2 = xyxy[2], x2 = xyxy[3];

            // then
            int total = 0;
            for (int nu = 1; nu <= 10; nu++) {
                int result = prefixSum[y2][x2][nu]
                        - prefixSum[y2][x1 - 1][nu]
                        - prefixSum[y1 - 1][x2][nu]
                        + prefixSum[y1 - 1][x1 - 1][nu];

                total += result > 0 ? 1 : 0;
            }
            output.append(total).append('\n');
        }

        System.out.println(output);

        br.close();
    }
}