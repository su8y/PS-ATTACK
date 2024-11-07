#include <bits/stdc++.h>
using namespace std;
/* https://www.acmicpc.net/problem/1927 최소 힙 */
struct compare {
    bool operator()(int a, int b) {
        return a > b;
    }
};
int main() {
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

    priority_queue<int, vector<int>, compare> pq;
    int n;
    cin >> n;
    int x;
    for(int i=0;i<n;i++) {
        cin >> x;
        if( x== 0) {
            if( pq.empty()) {
                cout << 0 << '\n';
            }else {
                cout <<  pq.top() << '\n';
                pq.pop();
            }
            continue;
        }
        pq.push(x);
    }

    return 0;
}
