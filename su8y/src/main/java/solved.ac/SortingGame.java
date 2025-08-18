package solved.ac;

import java.util.*;

public class SortingGame {
    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        List<Integer> list = Arrays.asList(1,2,5,9,7,10,4,3);
        int[] arr = {1, 2, 4, 3};
//        int count = bfs(list);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();
            int casei = scanner.nextInt();
            for (int j = 0; j < casei; j++) {

                list.add(scanner.nextInt());
            }
            System.out.println(bfs(list));
        }
//        System.out.println(count);
//        System.out.println(System.currentTimeMillis() - l+ "ms");
    }

    private static int bfs(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        Queue<List<Integer>> q = new LinkedList<>();
        Map<List<Integer>, Integer> distance = new HashMap<>();

        distance.put(arr, 0);
        q.offer(arr);

        while (!q.isEmpty()) {
            List<Integer> here = q.poll();


            if (sorted.equals(here)) {
                return distance.get(here);
            }
            int cost = distance.get(here);

            for (int i = 0; i < n; i++) {
                for (int j = i + 2; j <= n; j++) {
                    Collections.reverse(here.subList(i, j));
                    if (!distance.containsKey(here)) {
                        distance.put(new ArrayList<>(here), cost + 1);
                        q.offer(new ArrayList<>(here));
                    }
                    Collections.reverse(here.subList(i, j));
                }
            }
        }
        return -1;
    }
}
