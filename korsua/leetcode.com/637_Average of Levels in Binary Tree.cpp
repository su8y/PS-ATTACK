/**
637_Average of Levels in Binary Tree.cpp
 */
class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ret;
        queue<pair<TreeNode*, int>> q;
        int count[1001];

        q.push( {root, 0} );

        while(!q.empty()){
            auto [node, depth] = q.front();
            q.pop();
            if( !node ) continue;

            if( count[depth]==0 ) ret.push_back(0);
            count[depth]++;
            ret[depth] += node->val;
            q.push( {node->left, depth+1} );
            q.push( {node->right, depth+1} );
        }

        for(int i=0;i<ret.size();i++){
            ret[i] = ret[i]/(double)count[i];
        }

        return ret;
    }
};
