package solved.ac;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class 귀여운_라이언_15565 {
    static int K, N, M, T;
    private static final List<Integer> list = new ArrayList<>();

    /**
     * 완전 탐색코드는 시간초과가 난다. 왜냐하면 천만개의 입력이 들어오고 그것을 다 한다고가정했을때에 O(N^2) 이기 때문에 불가능 하다. 입력값이 5만이내여야한다.
     * 그렇다면 천만을 해결하긴 위해선 nlogN 이거나 O(N)의 시간복잡도가 필요하다.
     *
     * @return
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 1) list.add(i);
        }
        bw.write(solve() + "\n");


        bw.close();
        br.close();
    }

    private static int solve() {
        int min = Integer.MAX_VALUE;
        int left = 0, right = K - 1;
        if (list.size() < K) return -1; // 기저 사례 1: 리스트의 크기가 K보다 작을경우

        while (right < list.size()) {
            int value = list.get(right) - list.get(left);
            min = min(min, value);
            left++;
            right++;
        }

        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }
    /*
    static int min = Integer.MAX_VALUE;
    private static int solve(int index) {
        for (int i= 0 ; i < arr.length; i++) {
            if(arr[i] == 1){
                int value = calc(i);
                if(value != -1) min = min(min,value);
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private static int calc(int start){
        int count = 1; // start는 포함된걸로 생각
        for (int i = start + 1; i < arr.length; i++) {
            if(arr[i] == 1) count++;
            if(count == K) return (i - start) + 1;


        }
        return -1;
    }

    * */
}