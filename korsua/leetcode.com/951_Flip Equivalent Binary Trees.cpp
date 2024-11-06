/**
951_Flip Equivalent Binary Trees.cpp
- 루트의 값 비교 
- 자식이 다르면 플립
 */
class Solution {
public:
    bool flipEquiv(TreeNode* Y, TreeNode* X) {
        if(!Y && !X) return true;
        if(!Y || !X) return false; // 둘 다 NULL 이 아닐때 Y != X;
        if(Y->val != X->val) return false;
        
        bool before =  flipEquiv(Y->left, X->left) && flipEquiv(Y->right, X->right);
        flipChild(X);
        bool after =  flipEquiv(Y->left, X->left) && flipEquiv(Y->right, X->right);

        return before || after;
    }
    void flipChild(TreeNode* a){
        TreeNode* tmp = a->left;
        a->left = a->right;
        a->right = tmp;
    }
};
