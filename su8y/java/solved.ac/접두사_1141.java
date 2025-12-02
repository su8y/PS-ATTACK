package solved.ac;

import java.io.*;
import java.util.*;

public class 접두사_1141 {
    static int K, N, M, T;
    private static List<String> data;

    /**
     * @return
     */
    private static int solve(List<String> data) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String current = data.get(i);
            inputResult(current, result);
        }

        return result.size();
    }

    private static void inputResult(String str, List<String> result) {
        boolean check = false;
        for (int j = 0; j < result.size(); j++) {
            if (result.get(j).startsWith(str)) {
                check = true;
//                result.remove(j);
                break;
            }
        }
        if (check) {
//            result.add(str);
            return;
        }
        result.add(str);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        data = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            data.add(br.readLine());
        }
        int max = 0;
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        bw.write(solve(data) + "\n");


        bw.close();
        br.close();
    }
}