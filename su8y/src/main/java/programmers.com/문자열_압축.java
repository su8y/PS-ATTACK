package programmers.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class 문자열_압축 {
    // 문자열을 step씩 돌면서 숫자와 문자로 바꾼다
    // step을 증가 시킨다.
    // 문자열이 나눠질수있는것은 반만 가능하기 때문에 반까지만한다.
//    static StringBuilder builder = new StringBuilder();
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        String str = null;
        List<String> arr;

        for (int step = 1; step * 2 <= s.length(); step++) {
            str = s;
            arr = new ArrayList<>();
            while (str.length() >= step) {
                arr.add(str.substring(0, step));
                str = str.substring(step);
            }
            if (str.length() > 0) arr.add(str);
            int count = 1;
            StringBuilder builder = new StringBuilder();
            System.out.println();
            for (int j = 1; j <= arr.size(); j++) {
                if (arr.size() == j || !arr.get(j - 1).equals(arr.get(j))) {
                    if (count != 1) builder.append(count);
                    builder.append(arr.get(j - 1));
                    count = 1;
                } else count++;
            }
            answer = min(builder.toString().length(), answer);
        }
        return answer == Integer.MAX_VALUE ? 1 : answer;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(solution("ab"));
    }
}