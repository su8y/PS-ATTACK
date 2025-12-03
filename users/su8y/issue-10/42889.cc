/* 실패율 : https://school.programmers.co.kr/learn/courses/30/lessons/42889
실패율 = 통과한 사람수 / (거쳐간 사람수 + 통과한 사람 수)
O(M*log(M))
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
*/
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
#include <string.h>

using namespace std;

int sum[502];
int standing[502];
// N , M
vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
    memset(sum, 0x00, sizeof(sum));
    memset(standing, 0x00, sizeof(standing));
	for (auto stage : stages) {
		// 1 ~ N -1
		for (int i = 1; i < stage; i++)
			sum[i] += 1;
		standing[stage] += 1;
	}

	for (int i = 1; i <= N; i++)
		answer.push_back(i);
    
    auto compare = [](int a, int b) {
		double f_a = standing[a] == 0 ? 0 : (double)standing[a] / (sum[a] + standing[a]);
		double f_b = standing[b] == 0 ? 0 : (double)standing[b] / (sum[b] + standing[b]);
        
        if (f_a == f_b ) return a < b;

		return f_a >= f_b;
    };

	sort(answer.begin(), answer.end(), compare);

	return answer;
}
