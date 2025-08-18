package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 1202 https://www.acmicpc.net/problem/1202
 * <p>
 * ## 문제
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 * ## 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
 * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
 * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
 * 모든 숫자는 양의 정수이다.
 * <p>
 * ## 출력
 * 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
 * <p>
 * ## 해설
 * 보석이 총 N개가 있고 가방이 K개가 있다.
 * 보석은 무게와 가격을 가지고있는데 이때 K의 가방에 단 하나의 보석만 들어가면 되니 적절히 분배해서 넣으면 되는 문제이다.
 * 가장먼저 간단하게 Bruteforce알고리즘을 생각해보면
 * 최악의 경우 N개의 가방에 모든
 */
public class 주사위_1041 {
    private static final Egde[][] adjencyEdge = {
            {Egde.A, Egde.D, Egde.B},
            {Egde.B, Egde.A, Egde.C},
            {Egde.C, Egde.A, Egde.E},
            {Egde.D, Egde.B, Egde.F},
            {Egde.B, Egde.C, Egde.F},
            {Egde.E, Egde.D, Egde.A},
            {Egde.F, Egde.C, Egde.E},
            {Egde.E, Egde.F, Egde.D}
    };

    private static int[] solveEgde(int[] arr) {
        int[] totalList = {0, 51, 101, 151};
        for (int i = 0; i < 8; i++) {
            Egde[] adjencyPoint = adjencyEdge[i];
            int firstIndex = adjencyPoint[0].ordinal();
            int secondIndex = adjencyPoint[1].ordinal();
            int thirdIndex = adjencyPoint[2].ordinal();
            int sum = arr[firstIndex] + arr[secondIndex] + arr[thirdIndex];
            //3개인 경우
            if (totalList[3] > sum) totalList[3] = sum;
            //2개인 경우
            //(0,1) (1,2), (2,0)
            int sum2 = Math.min(arr[firstIndex] + arr[secondIndex], arr[secondIndex] + arr[thirdIndex]);
            sum2 = Math.min(arr[firstIndex] + arr[thirdIndex], sum2);
            if (totalList[2] > sum2)
                totalList[2] = sum2;
            if (totalList[1] > arr[firstIndex])
                totalList[1] = arr[firstIndex];
        }
        return totalList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(reader.readLine());
        int[] inputArr = new int[6];
        for (int i = 0; i < 6; i++) {
            inputArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        //각 개수(index) 위치에 최소값이 저장되어 있음
        int[] minArr = solveEgde(inputArr);
        BigInteger result = new BigInteger("0");
        if (N == 1) {
            Arrays.sort(inputArr);
            int sum = 0;
            for (int i = 0; i < inputArr.length - 1; i++) {
                sum += inputArr[i];
            }
            System.out.println(sum);
            return;
        }
        if (N > 0) {
            BigInteger 상단3개 = BigInteger.valueOf(minArr[3]).multiply(BigInteger.valueOf(4));
            result = result.add(상단3개);
            BigInteger 하단3개가2개가된경우 = BigInteger.valueOf(minArr[2]).multiply(BigInteger.valueOf(4));
            result = result.add(하단3개가2개가된경우);
        }
        if (N - 2 > 0) {
            BigInteger 바닥면을제외한모서리 = BigInteger.valueOf(minArr[2]).multiply(BigInteger.valueOf(N - 2)).multiply(BigInteger.valueOf(8));
            result = result.add(바닥면을제외한모서리);
            BigInteger 바닥면의모서리2개짜리가1개간된경우 = BigInteger.valueOf(minArr[1]).multiply(BigInteger.valueOf(4)).multiply(BigInteger.valueOf(N - 2));
            result = result.add(바닥면의모서리2개짜리가1개간된경우);
            BigInteger 중심의값들 = BigInteger.valueOf(N - 2).pow(2).multiply(BigInteger.valueOf(5)).multiply(BigInteger.valueOf(minArr[1]));
            result = result.add(중심의값들);
        }
        System.out.println(result);


    }

    // 모서리의 경우의수를 구하기 ABCDEF가 있을때 인접한것들끼리
    enum Egde {
        A, B, C, D, E, F, G
    }

}
