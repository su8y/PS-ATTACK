package solved.ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2713_규현이의_사랑을_담은_메시지 {
    private static final int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ", 3);
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[][] matrix = new int[n][m];
            StringBuilder secretStringBuilder = new StringBuilder();

            // 시크릿 문자열 생성
            if (input.length == 3) {
                String word = input[2];
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == ' ') {
                        secretStringBuilder.append("00000");
                    } else {
                        int x = word.charAt(i) - 'A' + 1; // A = 1
                        String binaryString = Integer.toBinaryString(x);
                        secretStringBuilder.append(String.format("%05d", Integer.parseInt(binaryString)));
                    }
                }
            }

            // 토네이도 매트릭스 생성
            makeTonadoMaxtrix(matrix, secretStringBuilder.toString());

            // 토네이도 매트릭스 내용 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    output.append(matrix[i][j]);
                }
            }
            output.append("\n");

        }

        System.out.println(output);
        br.close();
    }

    private static void makeTonadoMaxtrix(int[][] matrix, String sb) {

        int N = matrix.length;
        int M = matrix[0].length;
        int i = 0, j = 0, count = 0, dir = 0;
        boolean[][] visited = new boolean[N][M];

        while (true) {
            if ((i < 0 || i >= N || j < 0 || M <= j) || visited[i][j]) {
                break;
            }

            if (sb.length() <= count) {
                matrix[i][j] = 0;
            } else {
                matrix[i][j] = sb.charAt(count) - '0';
                count++;
            }
            visited[i][j] = true;


            int ny = i + dirs[dir][0];
            int nx = j + dirs[dir][1];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
                i = ny;
                j = nx;
            } else {
                dir = ++dir % 4;
                i = i + dirs[dir][0];
                j = j + dirs[dir][1];
            }
        }

    }
}