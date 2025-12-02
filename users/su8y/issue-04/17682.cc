#include <algorithm>
#include <cctype>
#include <cmath>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

const string NUMBER = "0123456789";
int solution(string s) {
	int answer = 0;

	// base condition
	if (s.size() == 0)
		return 0;

	vector<int> v;
	v.push_back(0);

	int num;
	char bonus;
	char option;
	istringstream is(s);

	while (is >> num) {
		v.push_back(num);
		bonus = is.get();
		switch (bonus) {
		case 'S':
			break;
		case 'D':
			v[v.size() - 1] = pow(v[v.size() - 1], 2);
			break;
		case 'T':
			v[v.size() - 1] = pow(v[v.size() - 1], 3);
			break;
		}
		option = is.get();
		if (option != '*' && option != '#') {
			is.unget();
			continue;
		}

		switch (option) {
		case '*':
			v[v.size() - 1] *= 2;
			v[v.size() - 2] *= 2;
			break;
		case '#':
			v[v.size() - 1] *= -1;
			break;
		}
	}

	for (auto &e : v)
		answer += e;

	return answer;
}
