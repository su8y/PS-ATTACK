#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/22866 탑 보기 
풀이:
  |   |
| |   |
| | | |
1 0 2 0
stack을 통해서 오른쪽을 향해서 보는 건물의 수 + 왼쪽을 향해서 보는 건물의 수를 구해준다. 
또한 가장 가까운 원소는 stack을 빼는 과정에서 top()에 있는 원소임을 알 수 있다. 

testcase 1:
5 
5 4 3 2 5
*/

#define endl '\n'
using pii = pair<int,int>;

/* 
원소를 빼내는 과정에서 st.top에 위치한 원소가 현재 idx에서 가장 가까운 원소이다. 
right와 left 두개의 view가있으니 2개 중 더 작은 조건을 구하면 된다. 
1. abs(cur_idx - target_idx) 
2. min(arr[target_idx], arr[target_idx2])
*/
void whilePopStackByTarget(const int target, vector<int>& cnt_view, stack<pii>& st, vector<vector<pii>>& closest_targets){
	while(!st.empty() && target >= st.top().first){
		auto [val, idx] = st.top(); st.pop();
		if(!st.empty()) closest_targets[idx].push_back(st.top());
		cnt_view[idx] += st.size();
	}
}
void whileClearStack(stack<pii>& st, vector<int>& cnt_view, vector<vector<pii>>& closest_targets){
	while(!st.empty()){
		auto [val, idx] = st.top(); st.pop();
		cnt_view[idx] += st.size();
		if(!st.empty()) closest_targets[idx].push_back(st.top());
	}
}
void countAsideGreaterEachOthers( const vector<int>& arr, const int n ){
	stack<pii> st; // val, index
	vector<vector<pii>> closest_targets(n);
	vector<int> cnt_view(n);

	for(int i=n-1; i>=0; i--){ // right direction
		// less than st.top() value
		whilePopStackByTarget(arr[i], cnt_view, st, closest_targets);
		st.push({arr[i],i});
	}
	whileClearStack(st, cnt_view, closest_targets);

	for(int i=0; i<n; i++){ // left direction 
		whilePopStackByTarget(arr[i], cnt_view, st, closest_targets);
		st.push({arr[i],i});
	}
	whileClearStack(st, cnt_view, closest_targets);


	for(int i=0;i<n;i++){ // output
		cout << cnt_view[i];
		if(cnt_view[i] != 0){

			if(closest_targets[i].size() == 2){
				pii first = closest_targets[i][0];
				pii second = closest_targets[i][1];
				
				bool condition = abs(first.second - i) ==  abs(second.second - i) ? first.second > second.second : abs(first.second -i) > abs(second.second -i);
				if(condition) swap(closest_targets[i][0], closest_targets[i][1]);
				
			}

			cout << " " << closest_targets[i][0].second + 1;
		} 
		cout << endl;
	}

}
int main(){
  fastio;
	int n;
	cin >> n;
	vector<int> arr(n);
	for(int i=0;i<n;i++) cin >> arr[i];

	countAsideGreaterEachOthers(arr, n);

	return 0;
}
