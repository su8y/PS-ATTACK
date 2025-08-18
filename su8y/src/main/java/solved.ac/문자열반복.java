package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int repeatCount = Integer.parseInt(st.nextToken());
            char[] str = st.nextToken().toCharArray();
            String result = repeatChar(str, repeatCount);
            System.out.println(result);
        }
    }

    public static String repeatChar(char[] str, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < repeatCount; j++) {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}
