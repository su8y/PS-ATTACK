#include <bits/stdc++.h>
using namespace std;
int n,m,w,h;

int main(){
    cin >> h >> w >> n >> m;
    int h_count=0, w_count=0;
    for(int i = 0 ; i < h; i += (n+1)){
        h_count++;
    }
    for(int i = 0 ; i < w; i += (m+1)){
        w_count++;
    }
    int ret;
    if(!h_count && !w_count) {
        ret = 0;
    } else if( !h_count || !w_count){
         ret = h_count == 1 ? h_count : w_count;
    } else {
        ret = h_count * w_count;

    }
    printf("%d\n", ret);
    return 0;
}
