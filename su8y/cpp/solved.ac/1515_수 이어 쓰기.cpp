#include <bits/stdc++.h>
using namespace std;

/*
https://www.acmicpc.net/problem/1515 수 이어 쓰기
*/
int match(string str, string target){
    int l=0,r=0;
    while(r < target.size()){
        if(str[l] == target[r]){
            l++; r++;
        }else {
            r++;
        }
    }
    return l;
}

void solve(string str){
    int dp[str.size()];
    dp[0] = str[0] - '0';
    if(dp[0] == 0) dp[0] = 10;

    for(int i=1;i<str.size();i++){
        int j;
        for(j=dp[i-1]+1;;j++){
            string cur_str = to_string(j);
            int match_count = match(string(str.begin()+i, str.end()), cur_str);
            if(match_count) {
                i += match_count - 1; // match_count는 항상 1을 포함하고 있다.
                break;
            }
        }

        dp[i] = j;
    }


    cout << dp[str.size()-1];
}
int main(){
    string str;
    cin >> str;
    solve(str);
    return 0;
}