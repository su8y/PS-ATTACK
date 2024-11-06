/**
199_Binary Tree Right Side View.cpp
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;

        bool visited[101];
        queue<pair<TreeNode*, int>> q;

        q.push( {root, 0} );

        while( !q.empty() ){
            auto [node, depth] = q.front();
            q.pop();
            if( !node ) continue;
            if( !visited[depth] ) {
                visited[depth] = true;
                ret.emplace_back( node->val );
            }
            q.push( {node->right, depth + 1} );
            q.push( {node->left, depth + 1} );
        }

        return ret;
    }
};
