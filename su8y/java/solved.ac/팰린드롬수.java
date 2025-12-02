package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n;
        while (!(n = br.readLine()).equals("0")) {
            isPalindrome(n);
        }


    }

    private static void isPalindrome(String n) {
        int len = n.length();
        int mid = len / 2;
        int i = 1;
        int j = 1;
        i = len % 2 == 0 ? 0 : 1;

        for (; mid + i < len; i++, j++) {
            if (n.charAt(mid + i) != n.charAt(mid - j)) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");

    }

    private static int len(int n, int len) {
        int res = len;
        if (n > 10) {
            res = len(n / 10, len + 1);
        }
        return res;
    }
}