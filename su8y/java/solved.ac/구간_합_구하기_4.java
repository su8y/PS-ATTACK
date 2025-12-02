package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_4 {
    static int n, m;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = prefixSum(i, j);
            System.out.println(result);
        }

    }

    private static int prefixSum(int i, int j) {
        if (i == j) return arr[j] - arr[i - 1];
        return arr[j] - arr[i - 1];
    }
}