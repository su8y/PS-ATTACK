/**
236_Lowest Common Ancestor of a Binary Tree.cpp
최소 분모공통 조상을 구하는 문제로 p와 q의 공통 조상을 구하면 된다. 
solve function은 간단하게 left와 right의 분할정복으로 구성되어 있으며 left와 right 둘다 true라면 그 자리에서 root를 반환한다. 
시간 복잡도: 노드의 개수 N 만큼 반복 해서 O(N)
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return NULL;
        if(root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root->left,p,q);
        TreeNode* right = lowestCommonAncestor(root->right,p,q);

        if(left && right) return root;

        return left ? left : right;
    }
};
