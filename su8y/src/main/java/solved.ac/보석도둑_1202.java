package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
public class 보석도둑_1202 {

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 5, 3, 2, 6, 10};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        List<Pair> jewelList = new ArrayList<>();
        List<Integer> bag = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int N, K;
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        boolean[] visited = new boolean[K];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            Pair jewel = new Pair(weight, value);
            jewelList.add(jewel);
        }

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine());
            int allowedWeight = Integer.parseInt(stringTokenizer.nextToken());
            bag.add(allowedWeight);
        }

        //입력받은 것들을 우선은 무게 오름차순, 가치 내림차순으로 정렬
        jewelList.sort(((o1, o2) -> {
            if (o1.weight == o2.weight)
                return o2.value - o1.value;
            return o1.weight - o2.weight;
        }));
        // 가방은 오름차순으로 정렬
        bag.sort(((o1, o2) -> o1 - o2));
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        long totalWeight = 0;

        for (int i = 0, j = 0; i < K; i++) {
            // j 는 jewelListf를 순회하는 iterator
            while (j < N && jewelList.get(j).weight <= bag.get(i)) {
                pq.offer(jewelList.get(j++).value);
            }
            if (!pq.isEmpty())
                totalWeight += pq.poll();
        }
        System.out.println(totalWeight);
    }

    private static class Pair {
        Integer weight;
        Integer value;

        public Pair(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }


    }
}
