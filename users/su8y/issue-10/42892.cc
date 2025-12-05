/* 길 찾기 게임 https://school.programmers.co.kr/learn/courses/30/lessons/42892
스터디: https://github.com/PS-ATTACK/PS-ATTACK
TREE: 트리 생성후 순회
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

struct TreeNode  {
    TreeNode *left;
    TreeNode *right;
    int data;
    int idx;
    TreeNode(int _data, int _idx) {
        this->data = _data;
        this->idx = _idx;
        this->left = NULL;
        this->right = NULL;
    }
};

void InsertNode(TreeNode *root, TreeNode *newNode) {
    if(newNode->data < root->data) {
        //left 
        if(root->left) {
            InsertNode(root->left, newNode);
        } else {
            root->left = newNode;
        }
    } else {
        //right
        if(root->right) {
            InsertNode(root->right, newNode);
        } else {
            root->right = newNode;
        }
        
    }
}

void PreorderSearch(TreeNode* root, vector<int> &v) {
    if (!root) return;
    v.push_back(root->idx);
    PreorderSearch(root->left, v);
    PreorderSearch(root->right, v);
    return;
}
void PostorderSearch(TreeNode* root, vector<int> &v) {
    if (!root) return;
    PostorderSearch(root->left, v);
    PostorderSearch(root->right, v);
    v.push_back(root->idx);
    return;
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer;
    
    for(int i=0;i<nodeinfo.size();i++) {
        nodeinfo[i].push_back(i + 1); // nodeinfo[i][2]에 vertex를 추가 (출력 대상)
    }
    
    sort(nodeinfo.begin(), nodeinfo.end(), [](auto a, auto b) { // x, y
        if(a[1] == b[1]) return a[0] > b[0];
			return a[1] > b[1];
	});
    
    TreeNode root(nodeinfo[0][0], nodeinfo[0][2]);
    for(int i=1;i<nodeinfo.size();i++){
        TreeNode *newNode = new TreeNode(nodeinfo[i][0], nodeinfo[i][2]);
        InsertNode(&root, newNode);
    }
    
    answer.push_back({});
    answer.push_back({});
    PreorderSearch(&root, answer[0]);
    PostorderSearch(&root, answer[1]);
	

    return answer;
}
