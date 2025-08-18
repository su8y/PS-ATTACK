#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/14658 하늘에서 별똥별이 빗발친다

풀이:
N,M = 50만이어서 2차원 배열을 만들어서 직접 다 sliding window 기법으로 해결하기에는 메모리가 초과될 것이다. 

각 별똥별의 위치에 트램펄린을 놔두고 범위에 포함되는지를 확인하여 문제를 푼다. 

*/

#define pii pair<int,int>

bool createMaremmo(pii coord, int l,pii target);
bool isContains(pii coord, int l, int y_l, pii target);

int main(){
	fastio;
	int n, m, l, k, a, b;
	cin >> n >> m >> l >> k;
	vector<pii> v;

	for(int i=0;i<k;i++){
		cin >> a >> b;
		v.push_back({a,b});
	}

	set<pii> compositeCoord;
	for(int i=0;i<k;i++){
		for(int j=0;j<k;j++){
			int min_y = min(v[i].first, v[j].first);
			int min_x = min(v[i].second, v[j].second);
			compositeCoord.insert({min_y,min_x});
		}
	}
	v.insert(v.end(), compositeCoord.begin(), compositeCoord.end());

	int max_val = 0;
	for(auto &coord: v){
		int count[5] = {0, };
		for(int i=0;i<k;i++){
			if(isContains(coord, l,  l,  v[i])) count[0]++;
			if(isContains(coord, l,  -l, v[i])) count[1]++;
			if(isContains(coord, -l, l,  v[i])) count[2]++;
			if(isContains(coord, -l, -l, v[i])) count[3]++;
		}

		max_val = max(max_val, *max_element(count, count+4));
	}
	cout << k - max_val << endl;

	return 0;
}

bool isContains(pii coord, int l, int y_l, pii target){
	int comArr[2] = {coord.first, coord.first + l };

	if(comArr[0] > comArr[1]) swap(comArr[0], comArr[1]);
	if(comArr[0] > target.first || comArr[1] < target.first) return false;

	comArr[0] = coord.second;
	comArr[1] = coord.second + y_l;
	if(comArr[0] > comArr[1]) swap(comArr[0], comArr[1]);
	if(comArr[0] > target.second || comArr[1] < target.second) return false;

	return true;
}
