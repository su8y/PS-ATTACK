/**
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
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
    int maxSum = INT_MIN;
    int sumHelper(TreeNode* root){
        if(!root) return 0;
        int lsum = max(0, sumHelper(root->left));
        int rsum = max(0, sumHelper(root->right));
        maxSum = max(maxSum, lsum + rsum + root->val); // 하위의 서브트리도 확인한다. 
        // lsum + rsum 은 하위 서브트리를 포함하는 것. path를 한 줄로 그리기 위해서는 l과 r의 최소값을 구한다. 
        return max(lsum, rsum) + root->val;
    }
    int maxPathSum(TreeNode* root) {
        sumHelper(root);
        return maxSum;
    }
}ㅁ;
