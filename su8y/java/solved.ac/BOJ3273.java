package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        int sum = 0;
        int left = 0, right = 0;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        while (true) {
            sum = arr[left] + arr[right];
            if (left == n - 1) break;
            if (sum > target) {
                left++;
                right = left + 1;
            }
            if (sum < target) {
                right++;
            }
            if (sum == target) result++;
        }
        System.out.println(result);


    }
}
