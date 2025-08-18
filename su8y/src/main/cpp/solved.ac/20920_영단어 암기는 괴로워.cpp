#include <bits/stdc++.h>

using namespace std;
/*
https://www.acmicpc.net/problem/20920 영단어 암기는 괴로워

자주 나오는 단어일수록 앞에 배치한다.
해당 단어의 길이가 길수록 앞에 배치한다.
알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

빈도수, 문자열

n , m m 길이 이상으로 필터링
hashMap 사용 빈도수 올리기
 */
#define pis pair<int,string>

bool compare(pis& a, pis& b){
    if(a.first != b.first) return a.first > b.first;
    if(a.second.size() != b.second.size())
        return a.second.size() > b.second.size();
    return a.second < b.second;
}


int main(){
    cin.tie(NULL); ios::sync_with_stdio(false);
    int n ,m;
    unordered_map<string, int> hashmap;
    cin >> n >> m;
    string str;
    for(int i = 0 ; i< n;i++){
        cin >> str;
        if(str.size() < m) continue;
        hashmap[str]++;
    }
    vector<pis> v;
    for(auto [key, value] : hashmap){
        v.emplace_back(value ,key);
    }
    sort(v.begin(), v.end(), compare);
    for(auto& u :v){
        cout << u.second << '\n';
    }

    return 0;
}