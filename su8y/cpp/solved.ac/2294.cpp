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
typedef pair<int, int> pii;

#define MAX 987654321

int T, N, M, K;

vector<int> c;
int cache[100001];
set<int> s;

int optimize(int n) {
    int &ret = cache[n];
    if (ret < MAX) return ret;
    FOR(i, c.size()) {
        //모든 방법수를 찾는다.
        if (n - c[i] < 0) continue;
        ret = min(
                ret,
                optimize(n - c[i]) + 1
        );
    }
    return ret;
}

int main() {
    FAST;
    cin >> N >> K;

    memset(cache, 0x3f, sizeof(int) * 100001);
    cache[0] = 0;
    FOR(i, N) {
        int tmp;
        cin >> tmp;
        if (s.count(tmp) >= 1)continue;
        s.insert(tmp);
        c.push_back(tmp);
        cache[tmp] = 1;
    }
    for (int k = 1; k <= K; k++) {
        int &ret = cache[k];
        for (auto &cost: c) {
            if (k - cost < 0) continue;
            ret = min(ret, cache[k - cost] + 1);
        }
    }


//    int result =  optimize(K);
//    if(result > MAX){
//        cout << -1 << endl;
//        return -1;
//    }
//    cout << result << endl;
    if (cache[K] > MAX) {
        cout << -1 << endl;
        return 0;

    }
    cout << cache[K];


    return 0;
}

