package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WildCard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> list = new ArrayList<>();
    static int[][] cache = new int[2001][2001];
    static String wildCard;
    static String str;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            wildCard = br.readLine();
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                str = br.readLine();
                for (int k = 0; k < 101; k++) {
                    Arrays.fill(cache[k], -1);
                }
                if (match3(0, 0)) {
                    list.add(str);
                }
                output_solve();
            }
        }
    }

    private static void output_solve() {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s\n", list.get(i));
        }
        list.clear();
    }

    public static boolean match3(int w, int s) {
        if (cache[w][s] != -1) return cache[w][s] == 1;
        // wild 카드와 str을 맞춰나간다.
        if (w < wildCard.length() && s < str.length() &&
                (wildCard.charAt(w) == '?' || wildCard.charAt(w) == str.charAt(s))) {
            boolean flag = match3(w + 1, s + 1);
            cache[w][s] = flag ? 1 : 0;
            return flag;
        }
        if (w == wildCard.length()) {
            cache[w][s] = 1;
            return s == str.length();
        }

        if (wildCard.charAt(w) == '*')
            if (match3(w + 1, s) || s < str.length() && match3(w, s + 1)) {
                boolean flag = match3(w + 1, s + 1);
                cache[w][s] = 1;
                return flag;

            }
        cache[w][s] = 0;
        return false;
    }
}
