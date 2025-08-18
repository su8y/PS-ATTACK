/*
* https://www.acmicpc.net/problem/3758 KCPC
 */
#include <bits/stdc++.h>
using namespace std;

#define teaminfo tuple<int,int,vector<int>>
bool compare(pair<int,teaminfo>& a, pair<int,teaminfo> b) {
    auto [a_count, a_time, a_scores] = a.second;
    auto [b_count, b_time, b_scores] = b.second;
    int a_sum = accumulate(a_scores.begin(), a_scores.end(),0);
    int b_sum = accumulate(b_scores.begin(), b_scores.end(),0);
    if( a_sum != b_sum) return a_sum > b_sum;
    if (a_count != b_count) return a_count < b_count;
    return a_time < b_time;

}
int main() {
    int T;
    cin >> T;
    for(int t=0;t<T;t++) {
        int n,k,target,m;
        cin >> n >> k >> target >> m;

        // team_id, 문제 제출 수, 마지막 제출 시간
        map<int, tuple<int,int,vector<int>>> team;
        for(int i=0;i<n+1;i++) team[i]={0,0,vector<int>(k+1)};

        int team_id, problem, score;
        for(int i=0;i<m;i++) {
            cin >> team_id >> problem >> score;
            auto &[count, time, scores] = team[team_id];
            count++;
            time = i;
            if(scores[problem] < score) scores[problem] = score;
        }
        vector<pair<int,teaminfo>> sorted =
            vector<pair<int,teaminfo>>(team.begin(), team.end());

        sort(sorted.begin(), sorted.end(), compare);
        for(int i=0;i<n;i++) {
            if(sorted[i].first == target) {
                cout << i + 1 << endl;
                break;
            }
        }
    }
    return 0;
}
