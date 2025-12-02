#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/1027 고층 건물
풀이:
현재 지점에서 순차적으로 기울기를 갱신해나가면서 최대 기울기만을 선택하는 문제 
5 5 [5] 5
0 0 [현재지점] 0
*/
#define pii pair<int,int>

#define endl '\n'
/* require start x == 0  */

double calcLean(pii start, pii dest){
	if(start.second == dest.second) return 0; // y변화가 없으면 기울기 1 
	double y_diff = dest.second - start.second;
	double x_diff = dest.first - start.first;
	return (double)y_diff / (double)x_diff;
}

int main(){
	fastio;
	int n;
	cin >> n;
	int heights[n], view_count[n];

	for(int i=0;i<n;i++) cin >> heights[i];
	int max_val = 0;
	int print_index = 11;
	for(int i=0;i<n;i++){
		int count = 0;
		pii cur = {0, heights[i]};

		int l, l_count;
		double l_lean = -1000000001.0F;
		l = i-1, l_count = 0;
		while(l >= 0){
			int dist = abs(i - l);
			pii building = {dist, heights[l]};
			double lean = calcLean(cur, building);
			if(l_lean < lean) {
				l_lean = lean;
				l_count++;
			}
			l--;
		}

		int r, r_count;
		double r_lean = -1000000001.0F;
		r = i+1, r_count = 0;
		while(r < n){
			int dist = r - i;
			pii building = {dist, heights[r]};
			double lean = calcLean(cur, building);
			
			if(r_lean < lean) {
				r_lean = lean;
				r_count++;
			}
			r++;
		}
		view_count[i] = r_count + l_count;
	}
	cout << *max_element(view_count, view_count+n) << endl;
	
	return 0;
}
