/*
* https://www.acmicpc.net/problem/20006 랭킹전 대기열
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
using namespace std;

struct Room {
    int first_level;
    map<string, int> players;
};

int getRoomNumber(int x, vector<Room> &rooms, int limit) {
    for (int i = 0; i < rooms.size(); i++) {
        int diff = rooms[i].first_level - x;
        if (abs(diff) <= 10 && rooms[i].players.size() < limit) {
            return i;
        }
    }
    return -1;
}

void printRoom(string message, Room &room) {
    cout << message << '\n';
    for (auto &[name,level]: room.players) {
        cout << level << ' ' << name << '\n';
    }
}

void printWaitingRoom(vector<Room> &rooms, int limit) {
    for (int i = 0; i < rooms.size(); i++) {
        if (rooms[i].players.size() == limit) printRoom("Started!", rooms[i]);
        else printRoom("Waiting!", rooms[i]);
    }
}

int main() {
    FASTIO
    int n, m;
    cin >> n >> m; // 플레이어수,  방의 정원

    int score;
    string player;
    vector<Room> rooms;

    for (int i = 0; i < n; i++) {
        cin >> score >> player;
        int x;
        if ((x = getRoomNumber(score, rooms, m)) != -1) {
            Room &room = rooms[x];
            room.players[player] = score;
        } else {
            map<string, int> players;
            players[player] = score;
            Room newRoom = {.first_level = score, .players = players};
            rooms.push_back(newRoom);
        }
    }
    printWaitingRoom(rooms, m);

    return 0;
}
