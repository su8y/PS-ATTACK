package solved.ac;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger c = new BigInteger(st.nextToken());
//        BigInteger pow = a.pow(b);
        System.out.println(a.modPow(b, c));

    }


}
