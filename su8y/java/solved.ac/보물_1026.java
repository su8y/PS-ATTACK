package solved.ac;

import java.io.*;
import java.util.Arrays;

public class 보물_1026 {
    private final static int MAX_INT = Integer.MAX_VALUE;
    private final static int MIN_INT = Integer.MIN_VALUE;
    private static int N, T;

    private static int solve(int n, int[] a, int[] b) {
        if (n == 1) return a[0] * b[0];
        int res = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            res += a[i] * b[n - i - 1];
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solve(N, a, b));

        bw.close();
        br.close();
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static public Pair of(int x, int y) {
            return new Pair(x, y);
        }
    }
}