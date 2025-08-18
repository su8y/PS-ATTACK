package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판칠하기 {
    final static char[][][] arr = {
            {
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
            },
            {
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
            }
    };
    static int n, m;

    static char[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                input[i][j] = split[j].charAt(0);
            }
        }
        int minValue = 999999;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int res = Math.min(compareMap(i, j, input, arr[0]), compareMap(i, j, input, arr[1]));
                minValue = Math.min(minValue, res);
            }
        }
        System.out.println(minValue);


    }

    private static int compareMap(int y, int x, char[][] input, char[][] target) {
        int res = 0;
        for (int i = 0, t_i = y; i < 8; i++, t_i++) {
            for (int j = 0, t_j = x; j < 8; j++, t_j++) {
                if (input[t_i][t_j] != target[i][j]) res++;
            }
        }

        return res;
    }
}