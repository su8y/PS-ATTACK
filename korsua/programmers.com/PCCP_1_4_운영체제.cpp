/*
개어려움.
*/
#include <bits/stdc++.h>
#define load_priority_queue priority_queue<vector<int>, vector<vector<int>>, cmp2>
#define time_priority_queue priority_queue<vector<int>, vector<vector<int>>, cmp>

using namespace std;
struct cmp{
    bool operator()(vector<int>& a, vector<int>& b){
        return a[1] > b[1];
    }
};
struct cmp2{
    bool operator()(vector<int>& a, vector<int>& b){
        return a[0] != b[0] ? a[0] > b[0] : a[1] > b[1];
    }
};

void pushHeap(int i, time_priority_queue& timeHeap, load_priority_queue& loadHeap){
    while(!timeHeap.empty()){ // 실행 시간이 최초 프로그램 실행 시간보다 작은 프로그램들을 loading heap에 적재
        if(timeHeap.top()[1] > i) break;
        loadHeap.push(timeHeap.top());
        timeHeap.pop();
    }
}

vector<long long> solution(vector<vector<int>> program) {
    vector<long long> answer(10);
    
    priority_queue<vector<int>, vector<vector<int>>, cmp> startHeap(program.begin(), program.end());
    priority_queue<vector<int>, vector<vector<int>>, cmp2> loadHeap;
    
    int i = 0;
    
    while(!startHeap.empty() || !loadHeap.empty()){
        pushHeap(i,startHeap, loadHeap);
        if(loadHeap.empty()){
            i = startHeap.top()[1];
            continue;
        }
        vector<int> curr = loadHeap.top(); // score, start, during
        int score = curr[0];
        int start = curr[1];
        int during = curr[2];
        loadHeap.pop();
        
        answer[score-1] += i - start; // 대기시간  // score starts index 1
        i += during; // during i에 추가 
    }
    answer.insert(answer.begin(), i);
    return answer;
}
