/* https://www.acmicpc.net/problem/1260 DFS와 BFS
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define ll long long
using namespace std;

int n, m, v;
int visited[1001];

void dfs(int x, vector<int> &history, vector<vector<int> > &edge);

void bfs(int, vector<vector<int> >&);

int main() {
    cin.tie(0);
    cin >> n >> m >> v;
    vector<vector<int> > edge(n+1, vector<int>());
    int a, b;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        edge[a].push_back(b);
        edge[b].push_back(a);
    }
    for (int i = 0; i <= n; i++) sort(edge[i].begin(), edge[i].end());


    vector<int> history = {v};
    visited[v] = true;
    dfs(v, history, edge);
    for(auto &u : history) {
        cout << u << ' ';
    }
    cout << '\n';
    bfs(v, edge);


    return 0;
}
void bfs(int x, vector<vector<int> >& edge) {
    memset(visited, 0, sizeof visited);
    queue<int> q;
    q.push(x);
    visited[x] = 1;

    vector<int> history;
    while(!q.empty()) {
        int f= q.front();
        history.push_back(f);
        q.pop();
        for(int i= 0; i<edge[f].size(); i++) {
            int next = edge[f][i];
            if(visited[next]) continue;
            q.push(next);
            visited[next] = true;
        }
    }

    // output
    for(auto &u: history)  cout << u << " ";
}



void dfs_stack(int x, vector<vector<int> > &edge) {
    memset(visited, 0, sizeof visited);
    stack<int> q;
    q.push(x);
    visited[x] = 1;

    vector<int> history;
    while(!q.empty()) {
        int f= q.top();
        history.push_back(f);
        q.pop();
        for(int i= 0; i<edge[f].size(); i++) {
            int next = edge[f][i];
            if(visited[next]) continue;
            q.push(next);
            visited[next] = true;
        }
    }

    // output
    for(auto &u: history)  cout << u << ' ';
    cout << '\n';
}

void dfs(int x, vector<int> &history, vector<vector<int> > &edge) {
    for (int i = 0; i < edge[x].size(); i++) {
        int next = edge[x][i];
        if (visited[next]) continue;
        visited[next] = 1;
        history.push_back(next);

        dfs(next, history, edge);
    }
}
