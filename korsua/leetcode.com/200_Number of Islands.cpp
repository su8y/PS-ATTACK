/*
200_Number of Islands.cpp
*/
class Solution {
public:
    int dy[4] = {1,0,-1,0};
    int dx[4] = {0,1,0,-1};
    int numIslands(vector<vector<char>>& grid) {
        int ret=0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                if(grid[i][j] == '0') continue;
                dfs(i,j,grid);
                ret++;
            }
        }
        return ret;
    }
    void dfs(int y, int x, vector<vector<char>>& grid){
        grid[y][x] = '0';
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= grid.size() || nx <0 || nx >= grid[0].size()) continue;
            if(grid[ny][nx] == '0') continue;
            dfs(ny, nx, grid);
        }
    }
};
