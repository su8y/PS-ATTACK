package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Shark {
    public int r;
    public int c;
    public int s;
    public int d;
    public int z;

    public Shark(int z) {
        super();
        this.z = z;
    }

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shark shark = (Shark) o;
        return z == shark.z;
    }
}

public class 낚시왕 {

    private static int[][] map;
    private static int answer = 0;
    private static final List<Shark> list = new ArrayList();
    private static int R, C, M;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = z;
            list.add(new Shark(r, c, s, d, z));
        }

        for (int i = 1; i <= C; i++) {
            fishing(i);
            moving();
            map = setUp();
        }
        System.out.println(answer);
    }

    static void fishing(int c) {
        for (int i = 0; i <= R; i++) {
            if (map[i][c] > 0) {
                System.out.println(answer);
                answer += map[i][c];
                list.remove(new Shark(map[i][c]));
                map[i][c] = 0;
                return;
            }
        }
    }

    static void moving() {
        for (int i = 0; i < list.size(); i++) {
            Shark temp = list.get(i);
            for (int s = 0; s < temp.s; s++) {
                int nr = dirs[temp.d][0] + temp.r;
                int nc = dirs[temp.d][1] + temp.c;
                if (isValid(nr, nc)) {
                    temp.r = nr;
                    temp.c = nc;
                } else {
                    if (temp.d % 2 == 0) temp.d++;
                    else temp.d--;
                    //방향만 바꿨기 때문에 s--해준다.
                    s--;
                }
            }
        }

    }

    static int[][] setUp() {
        int[][] tempMap = new int[R + 1][C + 1];
        for (int i = 0; i < list.size(); i++) {
            Shark temp = list.get(i);
            if (tempMap[temp.r][temp.c] == 0) {
                tempMap[temp.r][temp.c] = temp.z;
            } else {
                if (tempMap[temp.r][temp.c] < temp.z) {
                    list.remove(new Shark(tempMap[temp.r][temp.c]));
                    tempMap[temp.r][temp.c] = temp.z;
                } else {
                    list.remove(new Shark(temp.z));
                }
                i--;
            }
        }
        return tempMap;
    }

    static boolean isValid(int r, int c) {
        return r > 0 && r <= R && c > 0 && c <= C;
    }

}
