/*
* https://www.acmicpc.net/problem/1406 에디터
 *
 * abcd
 * L
 * dabc
 * P x
 * dabcx
 * D
 * abcdxd
 *
 */
#include <bits/stdc++.h>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define ll long long
using namespace std;

class Node {
public:
    Node *next;
    Node *prev;
    char val;

    Node(char _val): val(_val), next(nullptr), prev(nullptr) {
    }
};

void erase(Node* root) {
    if(!root->prev) return;
    Node* delNode = root->prev;
    if(root->prev->prev) {
        root->prev->prev->next = root;
    }
    root->prev = root->prev->prev;
    delete delNode;
}

void insert(Node *root, char val) {
    Node *newNode = new Node(val);
    newNode->prev = root->prev;
    newNode->next = root;
    if(root->prev) {
        root->prev->next = newNode;
    }
    root->prev = newNode;

}

void printNode(Node *root) {
    while (root->val != NULL) {
        cout << root->val;
        root = root->next;
    }
}

int main() {
    Node *root = new Node(NULL);
    Node *head = root;
    string str;
    cin >> str;
    for (int i = 0; i < str.size(); i++) {
        insert(root, str[i]);
    }

    int n;
    char command, x;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> command;
        if (command == 'P') {
            cin >> x;
            insert(root, x);
        } else if (command == 'L') {
            if(root->prev) root = root->prev;
        } else if (command == 'D') {
            if( root->next ) root = root->next;
        } else if (command == 'B') {
            erase(root);
        }
    }
    while(head->prev)  head = head->prev;
    printNode(head);
    return 0;
}
