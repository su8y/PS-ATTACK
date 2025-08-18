/*
 * 문제: 백준 17140번 - 이차원 배열과 연산 (https://www.acmicpc.net/problem/17140)
 *
 * 시간 복잡도: O(r * c * log r)
 */

package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
    // public class Main {
    private static int[][] a = new int[101][101];
    private static int col = 4;
    private static int row = 4;

    private static int[] sort(int[] arr) {
        Num[] nums = new Num[101];

        for (int i = 0; i <= 100; i++)
            nums[i] = new Num(i);

        for (int i = 1; i <= 100; i++)
            if (arr[i] != 0)
                nums[arr[i]].cnt++;

        Arrays.sort(nums, Comparator.comparing((Num n) -> n.cnt == 0).thenComparingInt(n -> n.cnt).thenComparingInt(n -> n.n));
        arr = new int[101];

        for (int i = 0; i < 50; i++) {
            if (nums[i].cnt == 0)
                return arr;

            int idx = (i << 1) + 1;

            arr[idx] = nums[i].n;
            arr[idx + 1] = nums[i].cnt;
        }

        return arr;
    }

    private static void op() {
        if (col < row) {
            int newCol = 0;

            for (int i = 1; i < row; i++) {
                int[] arr = new int[101];
                int len = 1;

                for (int j = 1; j <= 100; j++)
                    arr[j] = a[j][i];

                arr = sort(arr);

                for (int j = 1; j <= 100; j++) {
                    a[j][i] = arr[j];

                    if (arr[j] != 0)
                        len++;
                }

                newCol = Math.max(newCol, len);
            }

            col = newCol;
        } else {
            int newRow = 0;

            for (int i = 1; i < col; i++) {
                int[] arr = sort(a[i]);
                int len = 1;

                for (int j = 1; j <= 100; j++) {
                    a[i][j] = arr[j];

                    if (arr[j] != 0)
                        len++;
                }

                newRow = Math.max(newRow, len);
            }

            row = newRow;
        }
    }

    private static int start(int x, int y, int k) {
        for (int i = 0; i <= 100; i++) {
            if (a[x][y] == k)
                return i;

            op();
        }

        return -1;
    }

    private static class Num {
        int n;
        int cnt = 0;

        public Num(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < 4; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(start(r, c, k)));
        br.close();
        bw.close();
    }
}
