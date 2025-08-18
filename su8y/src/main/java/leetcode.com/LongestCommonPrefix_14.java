package leetcode.com;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestCommonPrefix_14 {
    static int K, N, M, T;

    private static boolean comparingStrs(String[] strs, int i) {
        for (int j = 1; j < strs.length; j++) {
            if (strs[0].charAt(i) != strs[j].charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        new LongestCommonPrefix_14().longestCommonPrefix(new String[]{"flower", "flow", "flight"});


        bw.close();
        br.close();
    }

    /**
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {// 해당 인덱스와 어쩌구
            if (comparingStrs(strs, i)) {
                sb.append(strs[0].charAt(i));
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}