package solved.ac;

import java.io.*;
import java.util.*;

public class BOJ_5545_최고의피자 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 토핑의 개수

    String[] s = br.readLine().split(" ");
    int dowW = Integer.parseInt(s[0]);
    int topingW = Integer.parseInt(s[1]);

    int dowCal = Integer.parseInt(br.readLine());

    List<Integer> topingCals = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      topingCals.add(Integer.parseInt(br.readLine()));
    }

    int calory = new BOJ_5545_최고의피자().maximumCaloriesByOneWon(dowW, topingW, dowCal, topingCals);

    System.out.println(calory);
  }

  private int maximumCaloriesByOneWon(int dowPrice, int topingPrice, int dowCalory, List<Integer> topingCaloryList) {
    topingCaloryList.sort((i1, i2) -> i2 - i1);

    // 도우는 항상 있어야 하기 때문에 기본 값으로 넣어둠
    int totalPrice = dowPrice;
    int totalCalory = dowCalory;

    for (var topingCalory : topingCaloryList) {
      double currentValue = totalCalory / (double) totalPrice;
      int nextCalory = (totalCalory + topingCalory);
      int nextPrice = (totalPrice + topingPrice);

      if (currentValue < nextCalory / (double) nextPrice) { // 현재 값보다 토핑을 추가한것이 가성비가 좋은 경우
        totalPrice = nextPrice;
        totalCalory = nextCalory;
      }
    }

    return totalCalory / totalPrice;
  }
}