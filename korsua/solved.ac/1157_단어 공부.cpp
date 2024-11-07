/*
* https://www.acmicpc.net/problem/1157
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(0);cout.tie(0);
using namespace std;

string s;
int main(){
    int count[26] = {0, };
    cin >> s;

    for(int i = 0; i < s.size(); i++){
        int index = s[i] - 'a';
        if(index < 0) index += 'a' - 'A';
        count[index] += 1;
    }

    int cnt = 0, max_index = 0, max_value = 0;

    for(int i = 0 ; i < 26; i++){
        if(count[i] > max_value) {
            max_value = count[i];
            cnt =1;
            max_index = i;
        }else if (count[i] == max_value){
            cnt++;
        }

    }

    if(cnt >= 2) {
        cout << "?" << endl;
    }else {
        printf("%c\n", max_index + 'A');
    }
    return 0;
}

