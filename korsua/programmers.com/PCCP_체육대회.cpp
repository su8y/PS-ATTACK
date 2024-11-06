/*
https://programmers.co.kr/app/with_setting/tests/131573/challenges/algorithms/12906?language=cpp
기본 backtracking 
*/
#include <bits/stdc++.h>

using namespace std;

int bt(vector<int>& arr, vector<vector<int>>& grid, vector<bool>& visit){
    int ret = 0;
    if(arr.size() == grid[0].size()){
        int sum =0;
        for(int i = 0 ; i < grid[0].size();i++){
            sum += grid[arr[i]][i];
        }
        return sum;
    }
    for(int i = 0 ; i < grid.size(); i++){
        if(visit[i]) continue;
        visit[i] = true;
        arr.push_back(i);
        ret = max(ret, bt(arr, grid, visit));
        visit[i] = false;
        arr.pop_back();

    }
    return ret;
}

int solution(vector<vector<int>> ability) {
    int answer = 0;
    vector<int> arr;
    vector<bool> visit(ability.size());

    return bt(arr, ability, visit);

}
