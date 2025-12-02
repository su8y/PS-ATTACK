package solved.ac;

import java.io.*;
import java.util.*;


// 진입 차수가 0인 노드를 가지고있는다.

/* 삽입: 진입 차수가 0인지 확인후 넣는다 . 그리고 relation 된 노드를 확인
- 문제는 relation된 노드의 관련 노드까지 확인해야함. 그 메커니즘을 구현하자.
*/


public class BOJ_14676_영우는사기꾼 {
    private static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static class LierTools {

        private final static int CONTRACTURE = 1;
        private final static int DESTROY = 2;
        private final Set<Integer>[] graph;
        private final List<List<Integer>> relationGraph;
        private final int[] isCreate;

        LierTools(int n, List<Pair> relation) {
            this.graph = new Set[n + 1];
            this.relationGraph = new ArrayList<>();
            this.isCreate = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                this.graph[i] = new HashSet<>();
                this.relationGraph.add(new ArrayList<>());
            }

            for (var p : relation) {
                this.graph[p.y].add(p.x);
                this.relationGraph.get(p.x).add(p.y);
            }
        }

        boolean process(Pair command) {
            int type = command.x;
            int node = command.y;
            List<Integer> to = relationGraph.get(node);
            switch (type) {
                case CONTRACTURE:
                    if (!graph[node].isEmpty()) return false; // 아무 연관관계가 없는 상태

                    if (isCreate[node] == 0) { // 최초 생성이라면
                        to.forEach(t -> graph[t].remove(node));
                    }

                    isCreate[node]++; // 생성 수 증가
                    break;
                case DESTROY:
                    if (isCreate[node] <= 0) return false; // 아무것도 생성이 안되어있으면
                    isCreate[node]--; // 생성 수 감소
                    if (!graph[node].isEmpty() && isCreate[node] == 0) { // 연관 관계를 엮어준다. 최대 3번
                        to.forEach(t -> graph[t].add(node));
                    }
                    break;
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Pair> relation = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation.add(new Pair(x, y));
        }

        List<Pair> commands = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            commands.add(new Pair(type, num));
        }

        LierTools lierTools = new LierTools(n, relation);

        for (Pair command : commands) {

            if (!lierTools.process(command)) {
                bw.write("Lier!\n");
                bw.close();
                br.close();
                return;
            }
        }

        bw.write("King-God-Emperor\n");

        bw.close();
        br.close();
    }
}