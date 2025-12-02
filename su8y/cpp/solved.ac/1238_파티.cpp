#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/1238 파티

풀이:
플로이드 워셜 문제 
*/

int n, m, x, a, b, c;
int main(){
	fastio;
	cin >> n >> m >> x;
	int dp[n+1][n+1];
	memset(dp, 0x3f3f3f3f, sizeof dp);
	for(int i=0;i<m;i++){
		cin >> a >> b >> c;
		dp[a][b] = c;
	}

	// init self-cost 
	for(int i=1;i<n+1;i++) dp[i][i] = 0;

	for(int k=1;k<=n;k++){
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i == j) continue;
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}

	int max_val = 0;
	for(int i=1;i<=n;i++){
		if(x == i) continue;
		max_val = max( max_val,dp[i][x] + dp[x][i]);
	}
	cout << max_val << endl;

	return 0;
}
