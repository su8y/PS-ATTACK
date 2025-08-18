#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <cstring>
#include <algorithm>
#include <set>
#include <map>
#include <functional>

#define FAST_IO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);

using namespace std;

string bracket = "(){}[]";

void insert_or_delete(vector<char> &v, char c) {
    if(v.empty()) {
        v.push_back(c);
        return;
    }
    char back = v.back();
    int index = bracket.find(c);
    if (index % 2 == 1) {
        if (back == bracket[index - 1]) {
            v.pop_back();
            return;
        }
    }
    v.push_back(c);
}

void solve() {
    string input;
    while (true) {
        vector<char> bracket_stack;
        getline(cin, input);
        if(input == ".") return;
        for (int i = 0; i < input.length(); ++i) {
            size_t f_i = bracket.find(input[i]);
            if (f_i  != string::npos) {
                insert_or_delete(bracket_stack, input[i]);
            }
        }
        string output = bracket_stack.empty() ? "yes" : "no";
        cout << output << endl;
    }


}


int main() {
    FAST_IO;
    solve();
    return 0;
}
