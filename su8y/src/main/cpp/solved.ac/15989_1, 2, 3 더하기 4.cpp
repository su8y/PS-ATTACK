#include <bits/stdc++.h>

using namespace std;
/* https://www.acmicpc.net/problem/15989 1, 2, 3 더하기 4*/

int main() {
    cin.tie(0);cout.tie(0);ios::sync_with_stdio(false);

    // create dp table
    int dp[4][10001];
    for(int i = 0 ; i < 4; i++){
        memset(dp[i], 0, sizeof dp[i]);
    }
    fill(dp[1], dp[1] + 10001, 1);
    dp[2][2] = 1;
    dp[2][3] = 1;
    dp[3][3] = 1;
    for (int i = 4; i < 10001; i++) {
        for (int j = 1; j <= 2; j++)
            dp[2][i] += dp[j][i-2];
        for (int j = 1; j <= 3; j++)
            dp[3][i] += dp[j][i-3];
    } // end create dp table

    int n, m;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> m;
        cout << dp[1][m] + dp[2][m] + dp[3][m] << '\n';
    }

    return 0;
}
