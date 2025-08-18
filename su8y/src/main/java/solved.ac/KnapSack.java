package solved.ac;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class KnapSack {

    static int N, M;
    static int[][] cache;
    private static int K;
    private static Knapsack[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new Knapsack[N];
        cache = new int[K + 1][N];
        for (int i = 0; i < K + 1; i++) Arrays.fill(cache[i], -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[i] = new Knapsack(w, v);
        }
        pack(K, N - 1);
        System.out.println(cache[K][N - 1]);
        List<Integer> res = new ArrayList<>();

        reconstruct(K, N - 1, res);
        for (Integer re : res) {
            System.out.println(re);
        }

    }

    static int pack(int capacity, int item) {
        if (item < 0) return 0;
        int ret = cache[capacity][item];
        if (ret != -1) return ret;

        //물건을 담지않는 경우
        cache[capacity][item] = pack(capacity, item - 1);
        //물건을 담는 경우
        if (capacity >= list[item].x) {
            cache[capacity][item] = Math.max(
                    pack(capacity, item - 1),
                    pack(capacity - list[item].x, item - 1) + list[item].y
            );
        }
        return cache[capacity][item];
    }

    static void reconstruct(int capacity, int item, List<Integer> pick) {
        if (item < 0) return;
        if (pack(capacity, item) == pack(capacity, item - 1)) {
            reconstruct(capacity, item - 1, pick);
        } else {
            pick.add(item);
            System.out.println(item);
            reconstruct(capacity - list[item].x, item - 1, pick);
        }
    }

    static class Knapsack {
        int x;
        int y;

        public Knapsack(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}