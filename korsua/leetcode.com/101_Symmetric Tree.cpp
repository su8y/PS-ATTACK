/**
101. Symmetric Tree
https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
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
    bool isSymmetric(TreeNode* root) {
        vector<int> left;
        vector<int> right;
        left_traverse(root->left, left);
        right_traverse(root->right, right);

        if(left != right) return false;
        return true;
    }
private:
    void left_traverse(TreeNode* root,vector<int>& v){
        if(root == NULL) {
            v.push_back(-111);
            return;
        }
        v.push_back(root->val);
        left_traverse(root->left, v);
        left_traverse(root->right, v);
    }

    void right_traverse(TreeNode* root,vector<int>& v){
        if(root == NULL) {
            v.push_back(-111);
            return;
        }
        v.push_back(root->val);
        right_traverse(root->right, v);
        right_traverse(root->left, v);
    }

};