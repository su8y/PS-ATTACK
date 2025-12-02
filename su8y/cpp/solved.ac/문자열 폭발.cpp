#include <bits/stdc++.h>

#define pii Pair<int, int>
#define pis Pair<int, string>
#define pdd Pair<double, double>
#define vvi vector<vector<int>>
#define FAST_IO cin.tie(NULL);cout.tie(NULL);ios::sync_with_stdio(false);

#define PRECODE template<typename T1, typename T2> struct Pair{ T1 y; T2 x; };
PRECODE

using namespace std;

#define MIN_VALUE 3
#define MAX_VALUE 11

stack<char> s;
string str;

string bomb;

void Bomb() {
    if(s.size() < bomb.size()) return;
    stack<char> q;
    bool flag = 1;
    for (int i = 0; i < bomb.size(); i++) {
        // 문자열과다르다면 flag를 false로바꾸고break;한다.
        char ch = s.top();
        s.pop();
        q.push(ch);
        if (bomb[bomb.size() - i - 1] != ch) {
            flag = 0;
            break;
        }
    }


    if(!flag){
        while(!q.empty()){
            char f= q.top();
            q.pop();
            s.push(f);
        }
    }
}

void Push(char ch) {
    s.push(ch);
    Bomb();
}


int main() {
    cin >> str;
    cin >> bomb;
    for ( int i=0; i<str.size(); i++){
        Push(str[i]);
    }
    if(s.size() ==0) {
        cout << "FRULA" << endl;
        return 0;
    }
    stack<char> tmpStack;
    while(!s.empty()){
        tmpStack.push(s.top());
        s.pop();
    }
    while(!tmpStack.empty()){
        cout << tmpStack.top();
        tmpStack.pop();
    }
    return 0;
}
