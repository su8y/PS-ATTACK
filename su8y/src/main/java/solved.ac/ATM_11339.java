package solved.ac;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11339 {
    private final static int MAX_INT = Integer.MAX_VALUE;
    private final static int MIN_INT = Integer.MIN_VALUE;
    private final static int SIZE = 1001;
    static int A, B, C, D, E, F, G, H, I, J, K, L, N, M, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            result += sum;
        }
        bw.write(result + "\n");


        bw.close();
        br.close();
    }
}