#include <algorithm>
#include <cctype> // isalpha
#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>

using namespace std;

vector<string> GetTwiceArray(string str) {
	string s = str;
	vector<string> v;
	transform(s.begin(), s.end(), s.begin(), ::tolower);
	for (int i = 0; i < s.size() - 1; i++)
		if (isalpha(s[i]) && isalpha(s[i + 1]))
			v.push_back(to_string(s[i]) + s[i + 1]);
	return v;
}

// x / y * MAGICNUM
int solution(string str1, string str2) {
	int answer = 0;
	// given
	vector<string> v1 = GetTwiceArray(str1);
	vector<string> v2 = GetTwiceArray(str2);

	map<string, int> m1;
	for (auto &e : v1)
		if (m1.count(e))
			m1[e]++;
		else
			m1[e] = 1;

	map<string, int> m2;
	for (auto &e : v2)
		if (m2.count(e))
			m2[e]++;
		else
			m2[e] = 1;

	set<string> st(v1.begin(), v1.end());
	st.insert(v2.begin(), v2.end());
	int x = 0;
	int y = 0;
	for (auto &k : st) {
		int c1 = m1.count(k) ? m1[k] : 0;
		int c2 = m2.count(k) ? m2[k] : 0;
		x += min(c1, c2);
		y += max(c1, c2);
	}
	if (y == 0)
		return 65'536;
	cout << x << " " << y << endl;
	answer = 65'536 * ((double)x / y);
	return answer;
}
