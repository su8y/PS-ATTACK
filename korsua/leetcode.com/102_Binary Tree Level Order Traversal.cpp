/**
102. Binary Tree Level Order Traversal;
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;

        queue<pair<TreeNode*, int>> q;
        q.push( {root, 0} );

        while( !q.empty() ){
            auto [node, depth] = q.front();
            q.pop();
            if( !node ) continue;
            if(ret.size() < depth+1) ret.push_back(vector<int>());

            ret[depth].push_back( node->val );
            q.push( {node->left, depth+1} );
            q.push( {node->right, depth+1} );
        }

        return ret;
    }
};
