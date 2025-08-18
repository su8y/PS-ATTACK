package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            minX = Math.min(minX, a);
            minY = Math.min(minY, b);
        }

        var guitarShop = new GuitarShop(minX, minY);
        int price = guitarShop.optimizeBuy(n);

        bw.write(price + '\n');

        bw.close();
        br.close();
    }

    private static class GuitarShop {
        private final int six;
        private final int one;


        public GuitarShop(int six, int one) {
            this.six = six;
            this.one = one;
        }

        public int optimizeBuy(int n) {
            if (six >= one * 6) {
                return one * n;
            }
            int res = (n / 6) * six;

            int y = n % 6; // 나머지
            if (y == 0) return res;

            res += Math.min(six, one * y);
            return res;
        }
    }
}