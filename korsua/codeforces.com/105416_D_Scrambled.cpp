/*
https://codeforces.com/gym/105416/problem/D
그리디 단어 카운팅 후 알파벳 순서대로 s에 집어넣는다. 
그후 단어 1개씩 남은 것들을 넣어주고 
s의 revser를 넣어주면 끝.
*/
#include <bits/stdc++.h>
using namespace std;
 
 
int main() {
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
    string s;
    cin >> s;
    int ch[26] = {0, };
    for(int i = 0 ; i<s.size();i++){
        int idx = s[i] -'a';
        ch[idx]++;
    }
    string ret;
 
    for(int i = 0 ; i< 26;i++){
        if(ch[i] == 0 || ch[i] < 2) continue; // 1개거나 0개면 패스
        int cnt = ch[i] / 2;
        ch[i] -= cnt * 2;
        for(int j = 0 ; j<cnt;j++){
            ret += ('a'+ i);
        }
    }
    string r_s =  ret;
    std::reverse(r_s.begin(), r_s.end());
    for(int i = 0 ; i< 26;i++){
        if(ch[i] == 0) continue;
        for(int j = 0 ; j< ch[i]; j++){
            ret += ('a' + i);
        }
    }
    cout << ret + r_s<<"\n";
 
 
    return 0;
}
