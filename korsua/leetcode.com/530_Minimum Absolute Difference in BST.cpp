/**
530. Minimum Absolute Difference in BST

- bi-tree 라서 정렬하는 하는 시간이 들지 않는다. 즉 정렬된 v를 얻는 시간은 $$O(N*logN)$$ 이다. 
- 정렬된 v에서 MIN 값을 얻는 시간복잡도는 $$O(N)$$ 이므로 시간복잡도 내에 풀수 있을것이다.

 */
class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        int ret = INT_MAX;
        vector<int> v;

        preorder(root, v);

        for(int i = 0; i< v.size()-1; i++){
            ret = min(ret, abs(v[i]-v[i+1]));
        }
        return ret;
    }
private:
    void preorder(TreeNode* node, vector<int>& v){
        if(!node) return;
        preorder(node->left, v);
        v.push_back(node->val);
        preorder(node->right, v);
    }
};
