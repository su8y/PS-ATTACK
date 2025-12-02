package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {


    public static void main(String[] args) throws IOException {
        int sum;
        int n;
        int[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        String s = br.readLine();
        stringTokenizer = new StringTokenizer(s);
        n = Integer.parseInt(stringTokenizer.nextToken());
        sum = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n];
        s = br.readLine();
        stringTokenizer = new StringTokenizer(s);
        int i = 0;

        while (stringTokenizer.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(solution(arr, n, sum));


    }

    public static int solution(final int[] arr, int n, int sum) {
        /*
         1 1 1 1
         o
        l
         */
        int result = 0, c_sum = 0, left = 0, right = 0;
        while (true) {
            if (c_sum < sum) {
                if (right == n) break;
                c_sum += arr[right];
                right++;
            } else {
                c_sum -= arr[left];
                left++;
            }
            if (c_sum == sum) {
                result++;
            }
        }

        return result;
    }
}
