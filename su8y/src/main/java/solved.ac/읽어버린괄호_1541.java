package solved.ac;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 55 - 50 + 40 일때에 + 연산자가 인접한것들을 모두 더해준다.
 * 55 - 90
 * test 2 : 30 +50 - 30 - 50 + 20
 * -> 80 - 30 - 70
 * 인접한 것들을 지워주기 위해 + 와 - 연산자는 맨 앞그리고 맨 뒤에 위치할수 없기 때문에
 * delims 포함 5개라고 가정했을시 1 3 인덱스에만 존재하게 된다.
 * 그럼 1 과 3의 인덱스를 조회해본 다음에 + 일시 그자리에서 arr[index-1] + arr[index +1] 을해준다.
 * <p>
 * 맨 앞이 - 일 경우는없기 때문에 그냥 처음에 숫자를 넣어주면 된다.
 */
public class 읽어버린괄호_1541 {
    private final static int MAX_INT = Integer.MAX_VALUE;
    private final static int MIN_INT = Integer.MIN_VALUE;
    static int A, B, C, D, E, F, G, H, I, J, K, L, N, M, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    private static int solve() {
        int res = 0;

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //input
        st = new StringTokenizer(br.readLine(), "+-", true);
        String[] arr = new String[st.countTokens()];
        for (int i = 0; i < arr.length; i++) arr[i] = st.nextToken();

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i].equals("+")) {
                long tmp = Long.parseLong(arr[i - 1]) + Long.parseLong(arr[i + 1]);
                arr[i - 1] = "None";
                arr[i] = "None";
                arr[i + 1] = String.valueOf(tmp);
            }
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("None")) {
                index = i;
                break;
            }
        }
        long result = Long.parseLong(arr[index]);
        for (int i = index + 2; i < arr.length; i += 2) {
            if (arr[i].equals("None")) continue;
            result -= Long.parseLong(arr[i]);
        }
        bw.write(result + "\n");


        bw.close();
        br.close();
    }
}