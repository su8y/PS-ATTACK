#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/4179 불!

풀이:
지훈이와 불은 매 분마다 한칸씩 이동한다. ( 지훈이가 먼저 이동 ~)
단순히 BFS를 돌린다면 O(NM)이다. 이때 불의 움직임을 생각해야 하는데 불의 움직임 또한 O(NM) 이므로 시간 복잡도 내에 해결할 수 있다. 
*/

#define pii pair<int,int>
const int dy[4] = {0, 0, 1, -1};
const int dx[4] = {1, -1, 0, 0};

int n, m;
char board[1001][1001];
bool visited[1001][1001];
vector<pii> fires; // 불 위치 배열

bool isOutOfBounds( int y, int x);
void MoveFire();
bool isEnd(pii coord);

void solve(pii start){
	queue<pair<pii, int>> q;
	int levels = 0;
	q.push({start, 0 }); // position, level

	memset(visited, 0, sizeof visited);

	while(!q.empty()){
		pair<pii, int> cur =  q.front(); q.pop();
		auto [y,x] = cur.first;

		if(visited[y][x]) continue;
		visited[y][x] = true;

		// Move Fire 
		if(levels != cur.second) { // 불 이동할 차례
			MoveFire();
			levels = cur.second;
		}

		if(board[y][x] != '.') continue;
		// check game end 
		if(isEnd(cur.first)) {
			cout << cur.second + 1 << endl;;
			return;
		}
		// Move J
		for(int i=0;i<4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(isOutOfBounds(ny, nx)) continue;
			if(board[ny][nx] == '.') { // 갈수있는 길일때만 넣는다. 
				q.push({{ny,nx}, cur.second + 1});
			}
		}
	}
	cout << "IMPOSSIBLE" << endl;
	return;
}
int main(){
	fastio;
	pair<int,int> position;

	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++){

			cin >> board[i][j];
			if(board[i][j] == 'F'){
				fires.push_back({i,j});
			} else if(board[i][j] == 'J') {
				board[i][j] = '.';
				position = {i,j};
			} 		
		}
	}

	solve(position);

	return 0;
}


bool isOutOfBounds( int y, int x){
	return y >= n || y < 0 || x >= m || x < 0;
}

void MoveFire(){
	vector<pii> newFires;
	for(auto &u: fires){
		for(int i=0;i<4;i++){
			int ny = u.first + dy[i];
			int nx = u.second + dx[i];

			if(isOutOfBounds(ny,nx)) continue;
			if(board[ny][nx] == '.') {
				board[ny][nx] = 'F';
				newFires.push_back({ny,nx});
			}
		}
	}

	fires = newFires;
}

bool isEnd(pii coord){
	if((coord.first == n-1 || coord.second == m-1 || coord.first == 0 || coord.second == 0) && 
		board[coord.first][coord.second] == '.'){
			return true;
	}
	return false;
}
