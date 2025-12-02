#include "bits/stdc++.h"

using namespace std;
#define ll long long;
#define endl "\n";

#ifdef BOJ
#define debug(x) \
    cout << "[DEBUG] " << #x << " == " << x << '\n';
#else
#define debug(x)
#endif

int dp[2500][2500];

int N;

/**
 * aiaiaiaiaiiaiaiaiaiaiaiaiiaiaiiaiaiiaiiaiiiiai
 * @param y
 * @param x
 * @param deps
 */



void solve() {
    string str;
    cin >> str;
    int len = str.length();
    N = len;

    memset(dp, 0, sizeof(dp[0]) * len);

    //해당 인덱스까지 dp를 확인하고 싶다면 str[j] str[i] 같은지 확인후
    // dp[j+1][i-1] 이 0이 아닌지 확인하면된다.
    //2글자까지의 dp테이블 생성
    if (len == 1) {
        cout << 1 << endl;
        return;
    }
    for (int i = 0; i < len; ++i) {
        dp[i][i] = 1;
        if (str[i] == str[i + 1])
            dp[i][i + 1] = 2;
    }
    for (int end = 2; end < len; ++end) {
        for (int start = 0; start < len; ++start) {
            if (str[end] != str[start])continue;
            if (dp[start + 1][end - 1] > 0) {
                dp[start][end] = end - start + 1;
            }
        }
    }
    for (int i = 0; i < len; ++i) {
        string str;
        for (int j = 0; j < len; ++j) {
            str += to_string(dp[i][j]);
        }
        debug(str);
    }

    int p[len + 1];
    memset(p, 0x3f, sizeof(int) * (len +1));
    p[0] = 0;
    // 단어가 1개일때 2개일때 점점 증가하면서 최소값을 찾는다. palindrome을 확인하기 위해서
    for (int i = 1; i <= N + 1; i++) {
        for (int j = 1; j <= i; j++) {
            if (dp[j - 1][i - 1] >= 1) p[i] = min(p[i], p[j - 1] + 1);
        }
    }


    string strg;
    for (auto &d: p) {
        strg += to_string(d);
    }
    cout << p[len];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solve();
    return 0;
}

