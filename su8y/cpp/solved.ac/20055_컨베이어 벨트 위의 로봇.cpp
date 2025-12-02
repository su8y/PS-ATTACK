#include <bits/stdc++.h>
using namespace std;
/* https://www.acmicpc.net/problem/20055 컨베이어 벨트 위의 로봇 */
int n, k;
int arr[1001] = {0,};
int cnt = 0;

void MoveRobot(int head, vector<int> &robot, int *arr) {
    // head + n 부터 head 까지 이동을 한다.
    for (int i = n - 1; i >= 0; i--) {
        int cur = (head + i) % (2 * n);
        int next = (cur + 1) % (2 * n);
        bool no_robot = robot[cur] == 0;
        bool can_not_move = robot[next] != 0;
        bool no_durability = arr[next] <= 0;
        if (no_robot || can_not_move || no_durability) continue;
        robot[next] = robot[cur];
        robot[cur] = 0;
        arr[next]--;
        if(arr[next] == 0) cnt++;
    }
}

void PutRobot(int head, vector<int> &robot, int *arr) {
    if (arr[head] > 0) {
        robot[head] = 1;
        arr[head]--;
        if(arr[head] == 0) cnt++;
    }
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < 2 * n; i++) {
        cin >> arr[i];
    }
    cnt = 0;
    for (int i = 0; i < 2 * n; i++) {
        if (arr[i] == 0) cnt++;
    }
    int i = 0;
    vector<int> robot(2 * n);
    while (true) {
        i++;
        int head_pointer = i % (2 * n);
        int head = ((2 * n) - head_pointer) % (2 * n);

        int put_down_index = (head + n - 1) % (2 * n);
        robot[put_down_index] = 0;

        MoveRobot(head, robot, arr);
        robot[put_down_index] = 0;
        PutRobot(head, robot, arr);

        if (cnt >= k) {
            cout << i << endl;
            break;
        }
    }

    return 0;
}
