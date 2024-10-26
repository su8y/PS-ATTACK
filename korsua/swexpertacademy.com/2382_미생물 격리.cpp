/*
 * 2382. [모의 SW 역량테스트] 미생물 격리
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
 합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.
 살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
 군집에 미생물이 한 마리 있는 경우 살아남은 미생물 수가 0이 되기 때문에, 군집이 사라지게 된다,
 O(N^2 * K * M)
 셀의 크기, 미생물 군집의 수, M시간
 y, x, dir, size

 // 군집들의 위치를 알려줌. // 이 것이 없으면 서로 같은 군집에 대해서 K^2 의 시간복잡도
 vector<int> topBoard[][];
 */


#include <bits/stdc++.h>

using namespace std;
int T,N,M,K;
int dy[4] = {-1,0, 1,0}; // 상 하 좌 우
int dx[4] = {0,-1,0, 1};
vector<tuple<int,int,int,int>> arr; // y,x, k, dir
set<int> top_board[101][101]; // k^2을 n^2바꾼 .

int mapDir(int d){
    switch (d) {
        case 1: return 0;
        case 2: return 2;
        case 3: return 1;
        case 4: return 3;
    }
}
void Initialazation(){
    arr.clear();
    for(int i = 0 ; i < 101;i++){
        for(int j = 0 ; j< 101; j++){
            top_board[i][j].clear();
        }
    }

    int y,x,size,dir;
    for(int i=0;i<K;i++){
        cin >> y >> x >> size >> dir;
        arr.emplace_back(y,x,size,mapDir(dir));
        top_board[y][x].insert(i);
    }
}
int reverseDir(int d){
    return (d + 2) % 4;

}
bool isTrap(int y, int x){
    if( y == 0 || x == 0) return true;
    if( y == N-1 || x == N-1) return true;
    return false;
}
void Move(){
    for(int i = 0 ; i < arr.size();i++){
        auto &[y,x,size,dir] = arr[i];
        if(size == 0) continue;
        int ny = y + dy[dir];
        int nx = x + dx[dir];

        // y x 써서 틀림
        if(isTrap(ny,nx)){
            size /= 2;
            dir = reverseDir(dir);
        }
        top_board[y][x].erase(i);
        top_board[ny][nx].insert(i);
        y = ny;
        x = nx;
    }
}
void Check(){
    for(int i = 0 ; i < N;i++){
        for(int j = 0 ; j < N;j++){
            set<int> &group = top_board[i][j];
            if(group.size() < 2) continue;
            int totalSize = 0;
            int maxIndex = 0;
            int maxSize = 0 ;

            for (auto &gi: group){
                auto &[y,x,size,dir] = arr[gi];
                totalSize += size;
                size = 0;
                if(maxSize >= size)  continue;
                maxSize = size;
                maxIndex = gi;
            }
            group.clear();
            group.insert(maxIndex);
            auto &[y,x,size,dir ] = arr[maxIndex];
            get<2>(arr[maxIndex]) = totalSize;
        }
    }

}
void PrintResult(int t){
    int total = 0;
    for(int i = 0 ; i < arr.size(); i++){
        auto [y,x,size,_] =  arr[i];
        total += size;
    }
    printf("#%d %d\n",t, total);
}
int main(){
    cin >> T;

    for(int t =1;t<=T;t++){
        cin >> N >> M >> K;
        Initialazation();
        for(int m=0;m<M;m++){
            Move();
            Check();
        }
        PrintResult(t);
    }

}
