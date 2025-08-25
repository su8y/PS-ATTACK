package solved.ac;

import java.io.*;
import java.util.*;


// 20:21
class BOJ_5052_전화번호_목록 {

  public static void main(String[] args) throws IOException {
    var inputs = new BufferedReader(new InputStreamReader(System.in));
    var T = Integer.parseInt(inputs.readLine());
    var outputs = new StringBuilder();
    var solution = new BOJ_5052_전화번호_목록();
    while (T-- > 0) {
      boolean canCall = true;
      var N = Integer.parseInt(inputs.readLine());
      var trie = new Trie();

      while (N-- > 0) {
        String str = inputs.readLine();
        if (!solution.constructureTrie(trie, str)) {
          canCall = false;
        }
      }

      if (canCall) {
        outputs.append("YES\n");
      } else {
        outputs.append("NO\n");
      }
    }

    System.out.println(outputs);
    inputs.close();
  }

  static class Trie {
    public Map<Character, Trie> words;
    public boolean isEnd;

    public Trie() {
      this.words = new HashMap<>();
      this.isEnd = false;
    }
  }

  public boolean constructureTrie(Trie trie, String str) {
    boolean ret = true;
    Trie head = trie;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      if (!head.words.containsKey(str.charAt(i))) { // 해당 문자가 없음
        head.words.put(c, new Trie());

      } else if (i == str.length() - 1) { // 마지막인데 문자가 있음
        ret = false;
      }

      if (head.words.get(c).isEnd) {
        ret = false;
      }

      if (i == str.length() - 1) { // 마지막이면 그냥 isEnd = true
        head.words.get(c).isEnd = true;
      }
      head = head.words.get(c);
    }

    return ret;
  }
}
