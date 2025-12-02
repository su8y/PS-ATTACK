#include <bits/stdc++.h>
using namespace std;

/* https://www.acmicpc.net/problem/4659
*/

const set<char> alpha1 = {'a', 'e', 'i', 'o', 'u'};
bool hasAnyAlpha(string str){
    for(auto& c: str) {
        if(alpha1.count(c)) return true;
    }
    return false;
}

bool validCondition3th(string str){
    for(int i=0;i<str.size() - 1;i++){
        if(str[i] == str[i+1]){
            if(str[i] == 'e' || str[i] == 'o') continue;
            return false;
        }
    }
    return true;
}

bool passCondition2th(string str){
    int v_count =0, c_count = 0;
    for(int i=0;i<str.size();i++) {
        if(alpha1.count(str[i])) {
            v_count++;
            c_count=0;
        }else {
            c_count++;
            v_count=0;
        }
        if(v_count == 3 || c_count == 3) return false;
    }

    return true;
}


int main(){
    cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
    string str;

    while(1) {
        cin >> str;
        if (str == "end") break;
        bool pass_1 = hasAnyAlpha(str);
        bool pass_2 = validCondition3th(str);
        bool pass_3 = passCondition2th(str);

        if (pass_1 && pass_2 && pass_3) {
            printf("<%s> is acceptable.\n", str.c_str());
        } else {
            printf("<%s> is not acceptable.\n", str.c_str());
        }

    }
    return 0;
}