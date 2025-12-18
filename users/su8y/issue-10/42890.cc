/* https://school.programmers.co.kr/learn/courses/30/lessons/42890#
슬라이딩 윈도우 방식으로 1 <= len <= M 에 해당하는 키 조합을 만들어 dfs
유일성은 각 key에 해당하는 rows에 대해서 vector<string>을 만들어 set으로 확인.
최소성 현재까지 방문한(visited) set에서 모든 원소를 돌며 현재 가지고있는 키 배열(bufArr)가 포함되어있는지
확인.
*/
#include <algorithm>
#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>
using namespace std;

bool CheckUniqueness(vector<int> keys, vector<vector<string>> &relation) {
    set<vector<string>> tmpSet;

    for (auto row : relation) {
        vector<string> combinationArr;
        for (auto key : keys)
            combinationArr.push_back(row[key]);
        tmpSet.insert(combinationArr);
    }
    return relation.size() == tmpSet.size();
}

bool CheckMinimumaly(set<vector<int>> &visited, vector<int> target) {
    set<int> test(target.begin(), target.end());
    for (auto visit : visited) {
        bool flag = true;
        for (int i = 0; i < visit.size(); i++) {
            if (test.count(visit[i]) == 0) flag = false;
        }
        if (flag == true) return false;
    }
    return true;
}


void dfs(int cur, int deps, vector<int> bufArr, set<vector<int>> &visited, vector<vector<string>> &relation) {
    if (!bufArr.empty() && !CheckMinimumaly(visited, bufArr)) { return; }

    if (bufArr.size() >= deps) {
        if (!bufArr.empty() && CheckUniqueness(bufArr, relation)) {
            visited.insert(bufArr);
        }
        return;
    }

    for (int i = cur; i < relation[0].size(); i++) {
        bufArr.push_back(i);
        dfs(i + 1, deps, bufArr, visited, relation);
        bufArr.pop_back();
    }
}

int solution(vector<vector<string>> relation) {
    set<vector<int>> visited;

    for (int i = 1; i <= relation[0].size(); i++) {
        dfs(0, i, {}, visited, relation);
    }

    return visited.size();
}
