#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#define endl '\n'
using namespace std;

/*
문제 : https://www.acmicpc.net/problem/1253 좋다

접근법: two-pointer O(n^2)
l,r 을 통해 두 수의 합을 구한다. 

*/

int solve(int n, int* arr){
	sort(arr, arr + n);
	int cnt=0;
	for(int i=0; i<n; i++) {
		int l=0, r = n-1;
		while(l < r){
			if(l == i || arr[i] > arr[l] + arr[r]) { l++; continue; }
			if(r == i || arr[i] < arr[l] + arr[r]){ r--; continue; } 
			cnt++;
			break;
		}
	}
	return cnt;
}

int main() {
	fastio;
	int n;
	cin >> n;
	int arr[n];
	for(int i=0; i<n; i++){
		cin >> arr[i];
	}

	cout << solve(n, arr) << endl;
	return 0;
}
