#include <bits/stdc++.h>

using namespace std;
/*
https://www.acmicpc.net/problem/13549 숨바꼭질 3
*/
class compare{
public:
    bool operator()(pair<int,int> &a, pair<int,int> &b){
        return a.second > b.second;
    }
};
int main() {
    int n, k;
    cin >> n >> k;

    priority_queue<pair<int,int>, vector<pair<int,int>>, compare> pq;
    int visited[100001] = {0,};
    memset(visited, 0x3f, sizeof visited);
    pq.push({n, 0});
    visited[n] = 1;
    int min_value = INT_MAX;
    while (!pq.empty()) {
        auto [cur, time] = pq.top();
        pq.pop();
        if (cur == k) {
            min_value = min(min_value , time);
            continue;
        }
        if (cur*2 <= 100000 && visited[cur * 2]>  time ) {
            pq.push({cur * 2, time});
            visited[cur * 2] = time;
        }
        if (cur + 1 <= 100000 && visited[cur + 1] > time + 1) {
            pq.push({cur + 1, time + 1});
            visited[cur + 1] = time + 1;
        }
        if (cur - 1 >= 0 && visited[cur - 1] > time + 1 ) {
            pq.push({cur - 1, time + 1});
            visited[cur - 1] = time + 1;
        }
    }
    cout << min_value << endl;
    return 0;
}