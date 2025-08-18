package solved.ac;


import java.util.*;

public class SortingGame2 {
    private static final Map<List<Integer>, Integer> toSort = new HashMap<>();

    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        List<Integer> list = Arrays.asList(1,2,5,9,7,10,4,3);
//
//        precalc(list.size());
//        System.out.println(solve(list));
//        System.out.println(System.currentTimeMillis() - l+"ms");
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();
            int casei = scanner.nextInt();
            for (int j = 0; j < casei; j++) {

                list.add(scanner.nextInt());
            }
            System.out.println(solve(list));
        }

    }

    public static void precalc(int n) {
        List<Integer> perm = new ArrayList<>();
        for (int i = 0; i < n; ++i) perm.add(i);

        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(perm);

        toSort.put(perm, 0);

        while (!q.isEmpty()) {
            List<Integer> here = q.peek();
            q.poll();

            int cost = toSort.get(here);

            for (int i = 0; i < n; i++) {
                for (int j = i + 2; j <= n; j++) {
                    Collections.reverse(here.subList(i, j));
                    if (!toSort.containsKey(here)) {

                        ArrayList<Integer> reverseItem = new ArrayList<>(here);
                        toSort.put(reverseItem, cost + 1);
                        q.offer(reverseItem);
                    }
                    Collections.reverse(here.subList(i, j));
                }
            }
        }

    }

    public static int solve(List<Integer> list) {
        int n = list.size();

        List<Integer> fixed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int smaller = 0;
            for (int j = 0; j < n; j++) {
                if (list.get(i) > list.get(j)) {
                    smaller++;
                }
            }
            fixed.add(smaller);
        }
//        System.out.println(fixed);
        return toSort.get(fixed);
    }

}
