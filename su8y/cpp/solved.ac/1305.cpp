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

int T, N, M;
string s;
vector<int> pi;


int main() {
    FAST;
    cin >> N;
    cin.ignore();
    getline(cin, s);
    pi.resize(s.size(), 0);

    int begin = 1, matched = 0;
    while (begin + matched < s.length()) {
        if (s[matched] == s[matched + begin]) {
            matched++;
            pi[begin + matched - 1] = matched;
        } else {
            if (matched == 0) {
                begin++;
            } else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }
    }

    cout << N - pi[N - 1];


    return 0;
}

