/**
114_Flatten Binary Tree to Linked List.cpp
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        if(!root) return;
        TreeNode* left = root->left;
        TreeNode* right = root->right;
        flatten(left);
        flatten(right);

        if(!left) return;
        root->left = nullptr;
        root->right = left;

        while(left->right){
            left = left->right;
        }
        left->right = right;
    }
};
