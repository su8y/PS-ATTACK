package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class 꿀_아르바이트_12847 {
    static int K, N, M, T;

    /**
     * @return
     */
    static int[] arr;

    public static long solve(int n, int x) {
        int start = 0;
        int end = x - 1; // 3 => 3 -1 = 2
        long sum = 0;
        long max = 0;
        for (int i = 0; i <= end; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = x; i < n; i++) {
            sum = sum - arr[i - x];
            sum = sum + arr[i];
            max = max(max, sum);

        }
/** 2 * for
 for (int i = 1; i + x < n; i++) {
 long sum = 0 ;
 for (int j = i; j < i+x; j++) {
 sum += arr[j];
 }
 max = max(max,sum);
 }
 */

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(n, x));
        bw.close();
        br.close();
    }
}