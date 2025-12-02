package solved.ac;

import java.io.*;
import java.util.*;

public class BOJ_1213_팰린드롬_만들기 {
    private static final String failed = "I'm Sorry Hansoo";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Map<Character, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (wordCount.containsKey(c)) {
                int count = wordCount.get(c);
                wordCount.put(c, count + 1);
            } else {
                wordCount.put(c, 1);
            }
        }

        ArrayList<Character> prefix = new ArrayList<>();
        int s_count = 0;
        char s_word = '-';
        for (Map.Entry<Character, Integer> e : wordCount.entrySet()) {
            if (e.getValue() % 2 == 1) {
                s_count++;
                s_word = e.getKey();
            }
            for (int i = 0; i < e.getValue() / 2; i++) prefix.add(e.getKey());
        }

        ArrayList<Character> suffix = new ArrayList<>(prefix);
        prefix.sort((o1, o2) -> o1 - o2);
        suffix.sort((o1, o2) -> o2 - o1);

        if (s_count > 1) {
            System.out.println(failed);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefix.size(); i++) {
            sb.append(prefix.get(i));
        }
        if (s_count != 0) sb.append(s_word);
        for (int i = 0; i < suffix.size(); i++) {
            sb.append(suffix.get(i));
        }
        System.out.println(sb);
    }
}