package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 13305 문제
 * 0에서부터 N-1 까지의 최소 값을 구하라 .
 * 반례 :
 * 뒤에서 부터 계산하는데 이런경우에는 계산이 정확하게 나오지 않았음.
 * 5
 * 1 1 1 1
 * 1 5 4 3 2
 */
public class 주유소_13305 {
    static int A, B, C, D, E, F, G, H, I, J, K, L, N, M, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    private static long[] dist;
    private static long[] cost;

    private static long solve() {
        long res = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (cost[i] < min) min = cost[i];
            res += min * dist[i]; // min 에는 fuel가 들어있다.
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dist = new long[N];//거리
        cost = new long[N];// 기름값

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        bw.write(solve() + "\n");


        bw.close();
        br.close();
    }
}