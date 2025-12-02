package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class 단어정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        List<MyString> list = new ArrayList<>();
        Set<MyString> list = new HashSet<>();
        while (n-- != 0) {
            list.add(new MyString(br.readLine()));
        }
//        while (!list.isEmpty()) {
//            System.out.println(list.poll().str);
//        }
        List<MyString> collect = list.stream().sorted().collect(Collectors.toList());
        for (var l : collect) {
            System.out.println(l.str);
        }

    }

    static class MyString implements Comparable<MyString> {
        String str;

        public MyString(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(MyString o2) {
            if (str.length() != o2.str.length()) return str.length() - o2.str.length();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == o2.str.charAt(i)) continue;
                if (str.charAt(i) - o2.str.charAt(i) < 0) {
                    //a - b 를 했다면
                    return -1;
                }
                return 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof MyString) {
                if (str == ((MyString) o).str) return true;
            }
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyString myString = (MyString) o;
            return Objects.equals(str, myString.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
        //        @Override
//        public int compare(MyString o1, MyString o2) {
//            if(o1.str.length() != o2.str.length()) return o1.str.length() - o2.str.length();
//            for(int i = 0 ; i < o1.str.length(); i++){
//                if(o1.str.charAt(i) == o2.str.charAt(i)) continue;
//                if(o1.str.charAt(i) - o2.str.charAt(i) < 0) {
//                    //a - b 를 했다면
//                    return -1;
//                }
//                return 1;
//            }
//            return 0;
//        }
    }
}