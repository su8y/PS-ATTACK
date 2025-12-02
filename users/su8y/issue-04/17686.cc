#include <algorithm>
#include <cctype>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

struct sort_file {
	int idx;
	string head;
	int num;
};

vector<string> solution(vector<string> files) {
	vector<string> answer;
	vector<sort_file> v;

	// parse
	for (int i = 0; i < files.size(); i++) {
		string str = files[i];
		int j = 0;
		string head = "";
		string parts = "";
		int num;
		while (j < str.size() && !isdigit(str[j])) {
			head += str[j];
			j++;
		}
		while (j < str.size() && isdigit(str[j])) {
			parts += str[j];
			j++;
		}

		num = stoi(parts);
		v.push_back({i, head, num});
	}
	stable_sort(v.begin(), v.end(), [](const auto &a, const auto &b) {
		string ah = a.head;
		string bh = b.head;
		transform(ah.begin(), ah.end(), ah.begin(), ::toupper);
		transform(bh.begin(), bh.end(), bh.begin(), ::toupper);
		if (ah != bh)
			return ah < bh;
		if (a.num != b.num)
			return a.num < b.num;
		return false;
	});

	for (auto &e : v)
		answer.push_back(files[e.idx]);

	return answer;
}
