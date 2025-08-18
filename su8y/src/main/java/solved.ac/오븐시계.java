package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오븐시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int 경과하는시간 = Integer.parseInt(br.readLine());
        int tmpMinutes = minutes + 경과하는시간;
        int tmpHour = tmpMinutes / 60;
        tmpMinutes = tmpMinutes % 60;

        hour = tmpHour + hour;
        minutes = tmpMinutes;
        hour -= (hour / 24) > 0 ? 24 : 0;

        System.out.printf("%d %d", hour, minutes);


    }
}