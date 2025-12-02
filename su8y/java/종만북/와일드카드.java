package 종만북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 와일드카드 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> list = new ArrayList<>();
    private static String wildCard;
    private static String str;


    private static final int[][] cache = new int[101][101];

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
                if (match2(0, 0)) {
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

    public static boolean match2(int w, int s) {
        if (cache[w][s] != -1) return cache[w][s] == 1;

        while (w < wildCard.length() && s < str.length() &&
                (wildCard.charAt(w) == '?' || wildCard.charAt(w) == str.charAt(s))) {
            w++;
            s++;
        }
        if (w == wildCard.length()) {
            return s == str.length();
        }
        if (wildCard.charAt(w) == '*')
            for (int step = 0; step + s <= str.length(); step++)
                if (match2(w + 1, step + s)) {
                    cache[w][s] = 1;
                    return true;
                }
        cache[w][s] = 0;
        return false;
    }
//    public static boolean match(String wildCard,String str){
//        int pos = 0;
//        while(pos <wildCard.length() && pos < str.length() &&
//                (wildCard.charAt(pos) == '?' || wildCard.charAt(pos) == str.charAt(pos))){
//                pos++;
//        }
//
//        if(pos == wildCard.length()) return pos == str.length();
//        if(wildCard.charAt(pos) == '*'){
//            for(int step = 0 ; pos + step <= str.length(); step++){
//                if(match(wildCard.substring(pos+1), str.substring(pos+step)))
//                    return true;
//            }
//        }
//        return false;
//    }
}
