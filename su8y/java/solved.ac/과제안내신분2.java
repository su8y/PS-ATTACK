package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 과제안내신분2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0; j < 28; j++) {
            i |= 1 << Integer.parseInt(br.readLine());
        }
        for (int j = 1; j <= 30; j++) {
            if ((i & (1 << j)) < 1) {
                sb.append(j).append('\n');
            }
        }
        System.out.println(sb);
    }
}
