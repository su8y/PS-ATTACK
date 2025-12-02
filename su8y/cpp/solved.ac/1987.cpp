#include "bits/stdc++.h"

using namespace std;

vector <string> graph;
set<char> passedPath;
bool visited[26];
int R, C;
int dir[4][2] = {
        {-1, 0},
        {1,  0},
        {0,  -1},
        {0,  1}
};
static int maxDeps = 0;

void dfs(int, int, int);

int main() {
    cin >> R >> C;
    for (int i = 0; i < R; ++i) {
        string inputTmp;
        cin >> inputTmp;
        graph.push_back(inputTmp);
    }

    visited[graph[0][0] - 'A'] = true;
    dfs(0, 0, 1);
    cout << maxDeps;

    return 0;
}


void dfs(int y, int x, int deps) {
    maxDeps = max(deps, maxDeps);
    set<char>::iterator iter;
    for (int i = 0; i < 4; ++i) {
        int nextY = y + dir[i][0];
        int nextX = x + dir[i][1];
        if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C)
            continue;
        char nextCharactor = graph[nextY][nextX];
        if (visited[nextCharactor - 'A']) continue;

        visited[nextCharactor - 'A'] = true;
        dfs(nextY, nextX, deps + 1);
        visited[nextCharactor - 'A'] = false;
    }
}
