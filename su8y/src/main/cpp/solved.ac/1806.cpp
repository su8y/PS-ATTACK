#include "bits/stdc++.h"

using namespace std;
#ifdef BOJ
#define debug(x)  ((void)0)
#define debugArr(c) ((void)0)
#else
#define debug(x) std::cout << "[DEBUG] " << #x <<" is " << x << '\n'
#define debugArr(c){ std::cout << "[DEBUG] "<< #c << ": "; for (const auto& elem : c) cout << elem << ", "; cout << '\n';}
#endif
#define FOR(i, N) for(int i=0; i<N;i++)
#define FFOR(i, N) for(int i=1; i<=N;i++)
#define FORN(N) while(N--)
#define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
#define ll long long
#define endl "\n"
#define MAX 100000001
typedef pair<int, int> pii;

int N, M, total, tmp, l, minResult = MAX;
vector<long> sub_totals;


int main() {
    FAST;
    // M이상인 최소 부분수열
    cin >> N >> M;
    sub_totals.push_back(0);
    FOR(i, N) {
        cin >> tmp;
        total += tmp;
        sub_totals.push_back(total);
    }
    FFOR(r, N) {
        int here = sub_totals[r];
        if (sub_totals[r] - sub_totals[l] < M) continue;
        for (int j = l; j <= N; j++) {
            if (sub_totals[r] - sub_totals[j] < M) {
                l = j - 1;
                break;
            }
        }
        minResult = min(minResult, r - l);
    }

    int result = minResult == MAX ? 0 : minResult;
    cout << result;

    return 0;
}

