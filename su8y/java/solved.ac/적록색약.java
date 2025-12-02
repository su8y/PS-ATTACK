package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 적록색약 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[][] maps = new String[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            maps[i] = str;
        }

        System.out.println(adfs(maps) + " " + sickdfs(maps));

    }

    public static int adfs(String[][] map) {
        visited = new int[map.length][map[0].length];
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j] == 0) {
                    count++;
                    dfs(i, j, map, map[i][j]);

                }
            }
        }
        return count;
    }

    public static int sickdfs(String[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(visited[i], 0);
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j] == 0 && "B".contains(map[i][j])) {
                    visited[i][j] = 1;
                    count++;
                    dfs(i, j, map, "B");
                } else if (visited[i][j] == 0 && "RG".contains(map[i][j])) {
                    visited[i][j] = 1;
                    count++;
                    dfs(i, j, map, "RG");
                }
            }
        }
        return count;
    }

    public static void dfs(int y, int x, String[][] map, String flag) {
        for (int i = 0; i < 4; i++) {
            int therey = y + dy[i];
            int therex = x + dx[i];
            if ((0 <= therex && therex < map[0].length)
                    && (0 <= therey && therey < map.length)
                    && visited[therey][therex] == 0 // 방문하지 않았다면
                    && flag.contains(map[therey][therex])) {
                visited[therey][therex] = 1;
                dfs(therey, therex, map, flag);
            }
        }
    }
}
