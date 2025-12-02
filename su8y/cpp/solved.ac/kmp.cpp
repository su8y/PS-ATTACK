#include "bits/stdc++.h"

using namespace std;
#ifdef BOJ
#define debug(x)  ((void)0)
#define debugArr(c) ((void)0)
#else
#define debug(x) std::cout << "[DEBUG] " << #x <<" is " << x << '\n'
#define debugArr(arr){ std::cout << "[DEBUG] "<< #arr << ": "; for (const auto& elem : arr) cout << elem << ", "; cout << '\n';}
#endif
#define debugArr(arr){ std::cout << "[DEBUG] "<< #arr << ": "; for (const auto& elem : arr) cout << elem << ", "; cout << '\n';}
#define FOR(i, N) for(int i=0; i<N;i++)
#define FFOR(i, N) for(int i=1; i<=N;i++)
#define FORN(N) while(N--)
#define FAST cin.tie(NULL);cout.tie(NULL); ios::sync_with_stdio(false)
#define ll long long
#define endl "\n"
typedef pair<int, int> pii;

int T, N, M;
string pattern, answer;
vector<int> pi;
vector<int> result;


int main() {
    FAST;
    getline(cin, answer);
    getline(cin,pattern);
    pi.resize(pattern.size(),0);

    if(pattern.size() > answer.size()) {
        cout << 0<< endl;
        return 0 ;
    }
    int i = 1, j = 0;
    while (i + j < pattern.size()) {
        if (pattern[i + j] == pattern[j]) {
            ++j;
            pi[i + j - 1] = j;
        } else {
            if (j == 0) {
                ++i;
            } else {
                i += j - pi[j - 1];
                j = pi[j - 1];
            }
        }
    }




    int begin = 0, matched = 0;
    while (begin <= answer.length() - pattern.length()) {
        if (matched < pattern.length() && answer[begin + matched] == pattern[matched]) {
            ++matched;
            if (matched == pattern.length()) result.push_back(begin);
        } else {
            if (matched == 0) {
                ++begin;
            } else {
                begin += matched - pi[matched - 1];
                matched = pi[matched - 1];
            }
        }

    }

    debugArr(pi);
    cout << result.size() << endl;
    for (auto &i: result) {
        cout << i + 1 << " ";
    }


    return 0;
}

