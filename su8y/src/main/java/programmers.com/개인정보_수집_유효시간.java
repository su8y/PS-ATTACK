package programmers.com;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 개인정보_수집_유효시간 {
    static int K, N, M, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Solution solution = new Solution();
        int[] solution1 = solution.solution(
                "2020.01.01",
                new String[]{
                        "Z 3", "D 5"

                }, new String[]{
                        "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D", "2019.01.01 D"
                }
        );
        for (int i : solution1) {
            System.out.println(i);
        }


        bw.close();
        br.close();
    }

    /**
     * UserInfo로 풀었더니 안됌 그냥 있는 라이브러리 쓰자
     *
     * @return
     */

    static class Solution {
        //        class UserInfo {
//            int year;
//            int month;
//            int day;
//
//            public UserInfo(int year, int month, int day) {
//                this.year = year;
//                this.month = month;
//                this.day = day;
//            }
//            public boolean compare(UserInfo userInfo){
//                if(year > userInfo.year){ // 연도가 작다면 바로 false
//                    return false;
//                }
//                if(month > userInfo.month){ // 연도가 크거나 같을때 month가 작다면 ?
//                    return false;
//                }
//                // 2022 . 05 .30
//                // 2022 . 06 . 20
//                if(month == userInfo.month){
//                    if(day >= userInfo.day){
//                        return false;
//                    }
//                }
//                return true;
//            }
//        }
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> result = new ArrayList<>();
            String[] split = today.split("\\.");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            // 오늘 날짜 저장
//            UserInfo uToday = new UserInfo(year, month, day);
            LocalDate now = LocalDate.of(year, month, day);

            //타입별 개인정보 저장기간 해시맵 저장
            HashMap<String, Integer> hash = new HashMap<>(); // Type, Month
            for (String term : terms) {
                String[] s = term.split(" ");
                String type = s[0];
                int terms_month = Integer.parseInt(s[1]);
                hash.put(type, terms_month);
            }
            int number = 1; // index 넘버
            for (String privacy : privacies) {
                String[] s = privacy.split(" ");// 날짜와 타입 분리

                String[] date = s[0].split("\\."); // 날짜
                Integer termsMonth = hash.get(s[1]);// type별 month 가져오기
                int pYear = Integer.parseInt(date[0]);
                int pMonth = Integer.parseInt(date[1]) + termsMonth; // month에다가는 가져온 termMonth 더해주기
                /**
                 * 반례
                 * 2020 12 01 A
                 * A 12
                 * */
//                if(pMonth > 12) {
//                    int i = pMonth/12;
//                    pMonth %= 12;
//                    pYear += i;
//                }
                while (pMonth > 12) {
                    pMonth -= 12;
                    pYear += 1;
                }
                int pDay = Integer.parseInt(date[2]);
//                UserInfo pUser = new UserInfo(pYear,pMonth,pDay);
                LocalDate tmp = LocalDate.of(pYear, pMonth, pDay);
//                if(uToday.compare(pUser) == false){
//                    result.add(number);
//                }
                if (now.isAfter(tmp) || now.isEqual(tmp)) {
                    result.add(number);
                }
                number++;
            }


            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}