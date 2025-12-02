package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> wordMap = new HashMap<>();

        char[] q_arr = st.nextToken()
                .toUpperCase()
                .toCharArray();
        for (char c : q_arr) {
            if (wordMap.containsKey(c)) {
                //원래값 증가
                int original = wordMap.get(c) + 1;
                wordMap.get(c);
                wordMap.replace(c, original);
            } else {
                wordMap.put(c, 1);
            }
        }
        List<Map.Entry<Character, Integer>> collect = wordMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    return o2 - o1;
                }))
                .collect(Collectors.toList());

        if (collect.size() == 0) {
            return;
        }
        if (collect.size() == 1) {
            System.out.println(collect.get(0).getKey());
        } else {
            if (collect.get(0).getValue().equals(collect.get(1).getValue())) {
                System.out.println("?");
            } else {
                System.out.println(collect.get(0).getKey());
            }
        }
    }
}
