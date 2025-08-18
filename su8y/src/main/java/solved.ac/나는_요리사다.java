package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나는_요리사다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = 5;
        int max_n = 0;
        int max_sum = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            if (max_sum < sum) {
                max_sum = sum;
                max_n = i;
            }
        }
        System.out.println(max_n + " " + max_sum);


    }
}
