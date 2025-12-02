package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1235 {
    /**
     * 3
     * 1212345
     * 1212356
     * 0033445
     * 최소값을 구하라.
     * <p>
     * 최소값 length = 1과 최대값 length 7일때 이분 탐색을 하여 구한다.
     * (1 + 7) /2 를 해서 우선 길이 4일때를 확인해보고 경우의 따라 2가지로 나눈다.
     * <p>
     * 길이 4일때의 값들이 만약 같다면 길이를 늘려봐야 하기 때문에 left = 4로 다시줘서 이분탐색을한다.
     * 만약 다르다면 더 낮은 경우를 찾아볼수있기 때문에 right = 4로 나눠본다.
     */

    private static boolean checkings(String[] strings, int point) {
        Set<String> set = new HashSet<>();
        for (String string : strings) {
            // 뒤에 자리수
            set.add(string.substring(string.length() - point));
        }
        return set.size() == strings.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; ++i) {
            str[i] = br.readLine();
        }
        int lo = 0;
        int hi = str[0].length() + 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (checkings(str, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        System.out.println(hi);
    }
}