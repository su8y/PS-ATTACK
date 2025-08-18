package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AToB {

    private static long b;
    private static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        solve(a, 1);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void solve(long a, int deps) {
        if (a == b) res = Math.min(deps, res);
        if (a > b) return;
        solve(a * 2, deps + 1);
        solve((a * 10) + 1, deps + 1);
    }
}