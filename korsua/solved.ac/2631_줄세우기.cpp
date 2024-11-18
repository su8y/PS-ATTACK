#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/2631 줄세우기

풀이:
N = max 200 min 2

배열이 주어졌을 때 가장 긴 증가하는 부분 수열을 찾으면 된다. LIS 
가장 긴 증가하는 부분 수열에 그렇지 못한 Item들을 넣어주는 연산 을 한다면 최적의 경로로 정렬된 배열을 얻을 수 있다. 

*/
int n;
vector<int> arr;
int solve(){
	vector<int> dp;
	for(int i=0;i<n; i++){
		int target = arr[i];
		auto it = lower_bound(dp.begin(), dp.end(), target);
		if(it == dp.end()){
			dp.push_back(target);
		}else{
			dp[it - dp.begin()] = target;
		}
	}
  
	return n - dp.size();

}
int main(){
	fastio;

	cin >> n;
	arr.resize(n);
	for(int i=0; i<n; i++) cin >> arr[i];

	cout << solve() << endl; 

	return 0;
}
