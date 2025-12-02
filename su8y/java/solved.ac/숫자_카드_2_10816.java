package solved.ac;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자_카드_2_10816 {
    static int K, N, M, T;

    /**
     * 각 인덱스에 있는 숫자의 개수를  출력
     * 1. 모든 것 탐색 N*M
     * 2. 이진 탐색으로 탐색 N* (M log M)
     * 3. Hash Table로 해당 값 개수 측정
     *
     * @return
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hMap = new HashMap();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken()); // input number , hMap key
            if (hMap.containsKey(tmp)) {
                int oldValue = hMap.get(tmp);
                hMap.replace(tmp, oldValue + 1);
            } else {
                hMap.put(tmp, 1);
            }
        }

        M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int resultTmp = Integer.parseInt(st.nextToken());
            Integer integer = hMap.get(resultTmp);
            sb.append(integer == null ? "0 " : integer + " ");
        }
        bw.write(sb.toString());


        bw.close();
        br.close();
    }
}