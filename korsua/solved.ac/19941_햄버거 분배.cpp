#include <bits/stdc++.h>
using namespace std;

/*
https://www.acmicpc.net/problem/19941 햄버거 분배
*/
bool eat(int st, int ed, string& str){
    for(int i=st; i <= ed; i++){
        if(str[i] == 'H'){
            str[i] = 'X';
            return true;
        }
    }
    return false;
}
int solve(int w, string& str, int len){
    int count = 0;
    for(int i=0;i<len;i++){
        if(str[i] == 'P'){
            bool canEat = eat(i-w, i+w, str);
            if(canEat){
                count++;
            }
        }
    }
    return count;
}
int main(){
    int n,k;
    cin >> n >> k;
    string str;
    cin >> str;
    cout << solve(k,str, n);
    return 0;
}