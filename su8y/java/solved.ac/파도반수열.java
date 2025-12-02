package solved.ac;

import java.util.Scanner;

public class 파도반수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            long result = solve(N);

            // print result
            System.out.println(result);
        }

    }

    private static long solve(int n) {
        long[] defaultTable = {1, 1, 1, 2, 2};
        if (n <= 5) return defaultTable[n];

        //init dpTable
        long[] dpTable = new long[n];
        System.arraycopy(defaultTable, 0, dpTable, 0, 5);

        for (int i = 5; i < n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 5];
        }

        return dpTable[n - 1];
    }
}
