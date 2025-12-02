package leetcode.com;
// 정사각형 N*N 크기에 나선형 배열 생생 (1...N)
public class LeetCode_59_Spiral_Matrix_II {
  private static int[][] directions = { {0, 1}, {1 ,0}, {0, -1}, {-1,0} };
  public int[][] generateMatrix(int n) {
    int[][] answer =  new int[n][n];
    int dir = 0;
    int[] curr = {0,0};
    answer[0][0] = 1;
    if (n == 1) return answer;

    for(int i=2;i<=n*n;i++){
      int ny = curr[0] + directions[dir][0];
      int nx = curr[1] + directions[dir][1];
      if(isOut(ny,nx,n) || answer[ny][nx] != 0) {
        dir = nextDir(dir);
        ny = curr[0] + directions[dir][0];
        nx = curr[1] + directions[dir][1];
        if(isOut(ny,nx,n)|| answer[ny][nx] != 0) break;
      }

      answer[ny][nx] = i;
      curr[0] = ny;
      curr[1] = nx;
    }
    return answer;
  }

  private int nextDir(int idx) {
    return (idx + 1) % 4;
  }

  private boolean isOut(int x, int y, int n) {
    return x < 0 || x >=n || y < 0 || y >= n;
  }
}
