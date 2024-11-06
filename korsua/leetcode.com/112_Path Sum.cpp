/**
  112. Path Sum
  https://leetcode.com/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
  Leaf 노드 일때 sum의 값이 0 인지를 확인하면되는 간단한 dfs문제 
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
    bool hasPathSum(TreeNode* root, int targetSum) {
        if( !root ) return false;
        bool isLeafNode = !root->left && !root->right;
        int nextTarget = targetSum - root->val;
        if( isLeafNode && nextTarget==0 ) return true;

        bool left = hasPathSum( root->left, nextTarget );
        bool right = hasPathSum( root->right, nextTarget );

        return left || right;
    }
};
