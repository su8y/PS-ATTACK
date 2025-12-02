/*
출력 조건 & 입력 조건 잘 읽기

*/
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

struct MusicInfo {
	int durationMin;
	string title;
	string content;
};

// str = HH:MM
int GetTime(string start, string end);
bool ContainsString(int duration, const string &original, const string &target);
string ScaleContent(string str);
// find title
// correct, long, first
string solution(string m, vector<string> musicinfos) {
	string answer = "";
	int durationMax = 0;
	string target = ScaleContent(m);

	for (int i = 0; i < musicinfos.size(); i++) {
		string musicinfo = musicinfos[i];
		istringstream iss(musicinfo);

		string start, end, title, content;
		getline(iss, start, ',');
		getline(iss, end, ',');
		getline(iss, title, ',');
		getline(iss, content, ',');

		string scaledContent = ScaleContent(content);
		int duration = GetTime(start, end);
		if (ContainsString(duration, scaledContent, target) &&
			duration > durationMax) {
			answer = title;
			durationMax = duration;
		}
	}

	return answer.empty() ? "(None)" : answer;
}

string ScaleContent(string str) {
	string scaled = "";
	while (!str.empty()) {
		if (str.size() >= 2 && str[1] == '#') {
			scaled += (str[0] + '#');
			str.erase(str.begin(), str.begin() + 2);
		} else {
			scaled += str[0];
			str.erase(str.begin(), str.begin() + 1);
		}
	}
	return scaled;
}
int GetTime(string start, string end) {
	int startMin = stoi(start.substr(0, 2)) * 60 + stoi(start.substr(3, 2));

	int endMin = stoi(end.substr(0, 2)) * 60 + stoi(end.substr(3, 2));

	return endMin - startMin;
}
bool ContainsString(int duration, const string &original,
					const string &target) {
	int nKey = original.size();
	int i = 0; // it
	int l = 0; // left pointer

	while (i < duration && l < target.size()) {
		if (original[i % nKey] == target[l]) {
			l++;
			i++;
		} else if (l != 0) {
			l = 0;
		} else {
			i++;
		}

		if (l == target.size())
			return true;
	}

	return false;
}
