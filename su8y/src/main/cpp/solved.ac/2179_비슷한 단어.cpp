#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0);

using namespace std;
/* 문제: https://www.acmicpc.net/problem/2179 비슷한 단어
풀이:

1. 모든 경우의 수를 체크하기에는 N^2 TC다. 
2. Trie를 사용하기엔 메모리 제한이 두렵다. (200만개의 노드 노드당 26byte + 필요)
3. sort를 한다.
사전순으로 배열을 정렬하기 때문에 비교하기 좋은 형태로 바뀜 하지만 , 정렬하는데 있어서 nLogN 그리고 문자열을 비교하는데에 있어서 n이 들기때문에 느릴거같다. 
이 방법 말고는 딱히 떠오르는게 없음. 

testcase 
4
zzz
aaa
aab
zzb
ans: zzz zzb
*/

#define pii pair<int,int>
#define endl '\n'

int getMatchPrefixLength(string& a, string& b){
	int len = max(a.size(), b.size());
	for(int i=0;i<len;i++){
		if(a[i] != b[i]) return i;
	}
	return len;
}
void solve(vector<string>& original){
	// sort & delete dup items
	set<string> s(original.begin(), original.end());
	vector<string> strs = vector<string>(s.begin(), s.end());

	int max_len = 0;
	unordered_set<string> us; // 
	for(int i=0;i < strs.size()-1; i++){
		int len = getMatchPrefixLength(strs[i], strs[i+1]);
		if( max_len > len) continue;

		if(max_len < len) {
			us.clear();
			max_len = len;
		}
		string substring = strs[i].substr(0, len);
		us.insert(substring);
	}

	unordered_set<string> output_sets;
	vector<string> outputs;
	for(int i=0;i< original.size();i++){
		string substring = original[i].substr(0, max_len);
		if(us.count(substring) != 0  && output_sets.count(original[i]) == 0) {
			us.clear();
			us.insert(substring);
			output_sets.insert(original[i]);
			outputs.push_back(original[i]);
		}
	}

	cout << outputs[0] << endl;
	cout << outputs[1] << endl;


}
int main(){
	fastio;

	int n;
	vector<string> strs;
	cin >> n;
	strs.resize(n);
	for(int i=0;i<n;i++) cin >> strs[i];

	solve(strs);

	return 0;
}
