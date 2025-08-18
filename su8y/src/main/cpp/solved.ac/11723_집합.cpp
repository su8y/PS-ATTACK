/*
https://www.acmicpc.net/problem/11723 집합
* add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
 */

#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;

int n;

int main(){
    FASTIO
    set<int> s ;

    cin >> n;

    int x;
    string cmd;
    for(int i=0; i<n; i++){
        cin >> cmd;
        if(cmd == "all"){
            s = { 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10,
                  11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        }else if(cmd == "empty"){
            s.clear();
        }else {
            cin >> x;
            if(cmd == "add") {
                s.insert(x);
            }else if(cmd == "remove"){
                s.erase(x);
            }else if(cmd == "check"){
                cout << (s.find(x) == s.end() ? 0 : 1) << "\n";
            }else if(cmd == "toggle"){
                if(s.find(x) == s.end()){
                    s.insert(x);
                }else {
                    s.erase(x);
                }
            }
        } /* endif else */
    } /* endloop */
}

