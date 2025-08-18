/*
* https://www.acmicpc.net/problem/5073
 */
#include <bits/stdc++.h>
using namespace std;

int checkTriangle(int *arr){
    int count = 1;
    int check = arr[0];
    for(int i = 1; i < 3; i++){
        if(arr[i] == check) count++;
    }
    return count;
}
int main(){
    int total, max;
    int arr[3];
    while(1){
        total = 0;

        cin >> arr[0] >> arr[1] >> arr[2];

        total = accumulate(arr, arr +3, 0);
        max = *max_element(arr , arr+ 3);

        if(total == 0) break;
        if( (total - max) <= max) {
            printf("Invalid\n");
            continue;
        }

        string message = "Invalid";
        int match_count = checkTriangle(arr);

        if(match_count == 3){
            message = "Equilateral";
        }else if(match_count == 2 || arr[1] == arr[2]) {
            message = "Isosceles";
        } else if(arr[1] != arr[2]){
            message = "Scalene";
        }
        cout << message << endl;

    }

}

