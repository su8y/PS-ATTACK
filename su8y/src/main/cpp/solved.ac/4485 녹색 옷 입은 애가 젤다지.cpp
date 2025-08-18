#include <bits/stdc++.h>
#define FASTIO cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/4485 녹색 옷 입은 애가 젤다지?.cpp

*/

#define vertax tuple<int, int, int> // y,x,cost

class compare{
public:
	bool operator()(vertax a, vertax b){
		return get<2>(a) > get<2>(b);
	}
};
bool isOutOfRange(int y, int x, int n){
	return y < 0 || y >= n || x < 0 || x >= n;
}
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0, 1,-1};

int main() {
	FASTIO;
	int board[126][126];
	int visited[126][126];

	int i=1;
	while(true){
		int n;
		cin >> n;
		if(n == 0) break;

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				cin >> board[i][j];
			}
		}

		priority_queue<vertax, vector<vertax>, compare> pq;
		memset(visited, 0x3f, sizeof visited);

		pq.push({0,0,board[0][0]});

		while(!pq.empty()){
			auto [y, x, cost] = pq.top(); pq.pop();
			// 현재 큐에서 꺼낸 경로마다 더 작은 경로가 있다면 패스한다.
			if(visited[y][x] <= cost) continue; 
			visited[y][x] = cost;

			for(int i=0;i<4;i++){
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(isOutOfRange(ny, nx, n)) continue;
				pq.push({ny, nx, board[ny][nx] + cost });
			}
		}
		cout << "Problem " << i++ << ": " << visited[n-1][n-1] << endl;
	}

	return 0;
}
