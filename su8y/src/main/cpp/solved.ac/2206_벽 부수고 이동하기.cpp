#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/2206 벽 부수고 이동하기
풀이:
0,0 N,M 항상 0 
복잡하게 생각하지말자 ~~~~

testcase : 
5 3
000
110
100
101
110
ans: 7
*/

#define endl '\n'
#define STOP_WALL 1
int dy[4] = {0,0,-1,1};
int dx[4] = {-1,1,0,0};
int n,m;

int main(){
	fastio;
	cin >> n >> m;

	vector<vector<int>> visited(n, vector<int>(m, 0));
	vector<string> arr(n);
	for(int i=0; i<n; i++) cin >> arr[i];

	int min_val = INT_MAX;
	queue<tuple<int,int,int,int>> q;

	q.emplace(0,0,1,0);

	while(!q.empty()){
		auto [y,x,dist,wall] = q.front(); q.pop();

		/*game end*/ 
		if(y == n-1 && x == m-1) { 
			min_val = min(min_val, dist);
			continue;
		}

		if(wall > STOP_WALL) continue;
		bool wall_visit = (visited[y][x] & (1 << wall)) == (1 << wall);
		if(wall_visit) continue;
		visited[y][x] |= 1 << wall;
		

		/* 4 direction */
		for(int i=0;i<4;i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if(arr[ny][nx] == '0'){
				q.push({ny,nx, dist+1, wall});
			} else {
				q.push({ny,nx, dist+1, wall + 1}); 
			}
			
		}
	}
	cout << (min_val == INT_MAX ? -1 : min_val) << endl;

	return 0;
}
