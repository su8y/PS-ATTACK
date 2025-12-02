package leetcode.com;

public class LeetCode_258_Add_Digits {
  public int addDigits(int num) {
    String numString = String.valueOf(num);
    while (numString.length() > 1) {
      int total = 0;
      for (int i = 0; i < numString.length(); i++) {
        total += numString.charAt(i) - '0';
      }
      numString = String.valueOf(total);
    }

    return Integer.valueOf(numString);
  }
}
