package solved.ac;

import java.io.*;

public class BOJ_30023_전구_상태_바꾸기 {
    private static final String failed = "I'm Sorry Hansoo";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String light = br.readLine();
        if (light.length() == 1) {
            System.out.println(0);
            return;
        }
        if (light.length() == 2) {
            if (light.charAt(0) == light.charAt(1)) System.out.println(0);
            else System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        int r = redLight(light.toCharArray());
        min = Math.min(min, r);
        int g = greenLight(light.toCharArray());
        min = Math.min(min, g);
        int b = blueLight(light.toCharArray());
        min = Math.min(min, b);


        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int redLight(char[] light) {
        int count = 0;
        for (int i = 1; i < light.length - 1; i++) {
            while (light[i - 1] != 'R') {
                light[i - 1] = switchColor(light[i - 1]);
                light[i] = switchColor(light[i]);
                light[i + 1] = switchColor(light[i + 1]);
                count++;
            }
        }
        if (light[light.length - 1] == 'R' &&
                light[light.length - 2] == 'R'
        ) {
            return count;
        }
        return Integer.MAX_VALUE;
    }

    private static int greenLight(char[] light) {
        int count = 0;
        for (int i = 1; i < light.length - 1; i++) {
            while (light[i - 1] != 'G') {
                light[i - 1] = switchColor(light[i - 1]);
                light[i] = switchColor(light[i]);
                light[i + 1] = switchColor(light[i + 1]);
                count++;
            }
        }
        if (light[light.length - 1] == 'G' &&
                light[light.length - 2] == 'G') {
            return count;
        }
        return Integer.MAX_VALUE;
    }

    private static int blueLight(char[] light) {
        int count = 0;
        for (int i = 1; i < light.length - 1; i++) {
            while (light[i - 1] != 'B') {
                light[i - 1] = switchColor(light[i - 1]);
                light[i] = switchColor(light[i]);
                light[i + 1] = switchColor(light[i + 1]);
                count++;
            }
        }
        if (light[light.length - 1] == 'B' &&
                light[light.length - 2] == 'B') {
            return count;
        }
        return Integer.MAX_VALUE;
    }

    private static char switchColor(char ch) {
        if (ch == 'R') return 'G';
        else if (ch == 'G') return 'B';
        else return 'R';
    }
}