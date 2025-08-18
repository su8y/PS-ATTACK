package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알람시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        minutes -= 45;
        if (minutes < 0) {
            hour--;
            minutes = 60 + minutes;
        }
        if (hour < 0) {
            hour = 24 + hour;
        }
        System.out.printf("%d %d", hour, minutes);


    }
}