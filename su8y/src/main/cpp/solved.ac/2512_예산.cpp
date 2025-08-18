#include <bits/stdc++.h>
using namespace std;
/* https://www.acmicpc.net/problem/2512 예산
*/
bool canGive(int n, vector<int>& arr, int m){

    int total = 0;
    for(int i = 0 ; i < arr.size(); i++){
        if (n > arr[i]){
            total += arr[i];
        }else {
            int diff =arr[i] - n;
            int diff2 =arr[i] - diff;
            total += diff2;
        }
    }
    return total <= m;
}
void solve(int target, vector<int>& arr){
    int max_value = *max_element(arr.begin(), arr.end());
    int min_value = *min_element(arr.begin(), arr.end());
    int lo =min_value;
    int hi = max_value + 1;
    while(lo + 1 < hi){
        int mid = (lo + hi) /2;
        if(canGive(mid, arr, target)) lo = mid;
        else hi = mid;
    }
    cout << lo << endl;
}

int main(){
    int n, m;
    vector<int> arr(n);
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    cin >> m;

    solve(m, arr);

    return 0;
}