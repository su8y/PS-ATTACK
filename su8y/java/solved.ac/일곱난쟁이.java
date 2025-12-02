package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            sum += tmp;
        }
        Arrays.sort(arr);


        int left = 0, right = arr.length - 1, target = sum - 100;
        while (left < right) {
            int currentNum = arr[left] + arr[right];
            if (target == currentNum) {
                arr[left] = 0;
                arr[right] = 0;
                break;
            }
            if (target > currentNum) left++;
            else right--;
        }
        for (int i : arr) {
            if (i == 0) continue;
            System.out.println(i);
        }


    }

}