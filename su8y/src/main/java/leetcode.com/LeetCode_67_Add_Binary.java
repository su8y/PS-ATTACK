package leetcode.com;

public class LeetCode_67_Add_Binary {
  public String addBinary(String a, String b) {

    int l = 0, r = 0;
    int up = 0;
    var outputs = new StringBuilder();

    while (l < a.length() || r < b.length()) {
      int sum = up;
      up = 0;
      if (l < a.length()) {
        sum += a.charAt(a.length() - l - 1) - '0';
      }
      if (r < b.length()) {
        sum += b.charAt(b.length() - r - 1) - '0';
      }

      if (sum >= 2) {
        up = 1;
      }
      if (sum == 0 || sum == 2) {
        outputs.append(0);
      } else {
        outputs.append(1);
      }

      l++;
      r++;
    }
    if (up == 1) {
      outputs.append(1);
    }

    // return outputs.toString();
    return outputs.reverse().toString();

  }
}
