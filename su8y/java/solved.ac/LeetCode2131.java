package solved.ac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * <p>
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 * <p>
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 * <p>
 * A palindrome is a string that reads the same forward and backward.
 * <p>
 * example 1 :
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created
 * <p>
 * 풀이방법 :
 * cl 또는 lc 가 연과배열에 들어있지 않다면 ? m(문자의 길이) + n의 반복 O(N)
 * cl 이라는 객체를 담는 연관형 배열을 생성 개수를 세줌
 * 들어있다면 true인지 false인지 확인후 -1 해주거나 1 해줌 0
 * 아니면 ?
 * -1을 한다면 그때 카운터를 1 증가시킴 . ( 두번째 연산때 1이아닌 -1 이 들어있다면 ?)
 */
public class LeetCode2131 {
    public static int longestPalindrome(String[] words) {
        int count = 0;
        int palin = 0;
        Arrays.sort(words);
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String reverseWord = String.valueOf(word.charAt(1)) + word.charAt(0);
            if (map.getOrDefault(reverseWord, 0) > 0) {
                count += 4;
                map.put(reverseWord, map.get(reverseWord) - 1);
                if (word.equals(reverseWord)) palin--;
            } else {
                if (word.equals(reverseWord)) palin++;
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        if (palin >= 1) count += 2;

        return count;
    }

}
