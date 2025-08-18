#include <bits/stdc++.h>

using namespace std;

/*https://www.acmicpc.net/problem/17484 진우의 달 여행 (Small)*/

#define tup tuple<int,int,int,int> // dir
int dy[3] = {1,1,1};
int dx[3] = {-1,0,1};
int main(){
    int n, m;
    cin >> n >> m;
    int board[6][6];
    int history[6][6];
    memset(history, 0x3f, sizeof history);

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> board[i][j];
        }
    }
    queue<tup> q;
    for(int i=0;i<m;i++){
        q.push({0,i,board[0][i],-1});
    }
    while(!q.empty()){
        auto [y,x,cost,d] = q.front(); q.pop();
        for(int i=0;i<3;i++){
            if(d == i) continue;
            int ny = y+dy[i],  nx = x+dx[i];
            bool isOutOfBounds = ny < 0 || ny >= n || nx <0 || nx >= m;
            if(isOutOfBounds ) continue;
            history[ny][nx] =min(history[ny][nx], cost+ board[ny][nx]);
            q.push({ny,nx, cost + board[ny][nx],i});
        }
    }
    cout << *min_element(history[n-1], history[n-1] + m);
    return 0;
}