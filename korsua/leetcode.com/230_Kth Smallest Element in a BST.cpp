/**
230_Kth Smallest Element in a BST.cpp
bi-tree의 특성을 생각해보자
배열의 특성은 
bi 트리의 중앙은 k + 1 이다. 
k보다 작다면 왼쪽 아니라면 오른쪽이다. 

하지만 이 문제는 배열이 아니므로 다른 접근 방법으로 해야한다. 

1. 나이브한 접근 방법으로는
    - vector에 넣어 k번째를 찾으면 된다. 그럼 공간복잡도 $$O(N)$$ 소요될 것이다. 

*/
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> v;

        preorder(root, v);
        
        return v[k-1];
    }
private:
    void preorder(TreeNode* root, vector<int>& v){
        if(!root) return;
        preorder(root->left, v);
        v.push_back(root->val);
        preorder(root->right, v);
    }
};
