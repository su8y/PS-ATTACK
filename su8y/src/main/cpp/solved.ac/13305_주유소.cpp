#include <iostream>
#include <vector>

using namespace std;
/* https://www.acmicpc.net/problem/13305 주유소
*/

long long calcCost(int cost, int s, int e, vector<int>& dist){
    long long total=0;
    for(int i=s;i<e;i++){
        total += (long long) dist[i] * (long long)cost;
    }
    return total;
}
void minCost(vector<int>& cost, vector<int>& dist,int len){
    long long ret=0;
    int cur=0;
    while(cur < len){
        int curMinCost = cost[cur];
        int i;
        for(i=cur+1;i<len;i++){
            if(curMinCost > cost[i]){
                break;
            }
        }
        ret += calcCost(curMinCost, cur, i, dist);
        cur = i;
    }
    cout << ret << '\n';
}

int main(){
    int n;
    cin >> n;
    vector<int> dist(n-1);
    vector<int> cost(n);
    for(int i=0;i<n-1;i++){
        cin >> dist[i];
    }
    for(int i=0;i<n;i++){
        cin >> cost[i];
    }
    minCost(cost,dist, n);
    return 0;

}

