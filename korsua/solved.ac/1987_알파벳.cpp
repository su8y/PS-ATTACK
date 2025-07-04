#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/1987 알파벳 
알파벳을 2번이상 지나치면 안되는 bfs 혹은 dfs알고리즘 
최대 몇칸을 움직이는건지이니 간단하게 dfs를 사용한다. 
*/

int dy[4] = {0,0,1,-1};
int dx[4] = {1,-1,0,0};
bool visited[26] = {0 ,};

bool isOutOfRange(int x, int len){
	return x <0 || x >= len;
}
int dfs(int y, int x,int deps, vector<string>& board, int n, int m){
	int ret = deps;

	for(int i=0;i<4;i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(isOutOfRange(ny, n) || isOutOfRange(nx, m)) continue;
		if(visited[board[ny][nx]- 'A']) continue;

		visited[board[ny][nx] - 'A'] = true;
		ret = max(ret, dfs(ny, nx, deps + 1, board, n ,m));
		visited[board[ny][nx] - 'A'] = false;
    }

	return ret;
}

int main() {
	fastio;
	int n, m;
	cin >> n >> m;
	vector<string> board(n);

	for(int i=0;i<n;i++){
		cin >> board[i];
	}
	memset(visited, 0 , sizeof visited);

	visited[board[0][0] - 'A'] = true;
	cout << dfs(0,0,1,board, n, m) << endl;
	visited[board[0][0] - 'A'] = false;

	return 0;
}
