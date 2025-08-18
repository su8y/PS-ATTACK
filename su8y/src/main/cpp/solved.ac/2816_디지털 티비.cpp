#include <bits/stdc++.h>

using namespace std;
/*
https://www.acmicpc.net/problem/2816
*/

int n;
string arr[100];

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }

    int i = 0;
    string history = "";

    while(arr[i] != "KBS1") {
        i++; history += "1";
    }
    while(i > 0) {
        swap(arr[i], arr[i-1]);
        history += "4";
        i--;
    }
    while(arr[i] != "KBS2") {
        i++; history += "1";
    }
    while(i > 1) {
        i--;
        history += "4";
    }

    cout << history << "\n";
    return 0;
}
