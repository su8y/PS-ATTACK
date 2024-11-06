/*
117_Populating_Next_Right_Pointers_in_Each_Node_II
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150
inorder 방식으로 트리를 순회하면 deps기반으로 순회할 수 있기 때문에 해당 deps를 배열의 순차적으로 저장한후 연결 
시간복잡도 O(N)
*/
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        constrcture(root, 0);
        for(int i=0;i<6001;i++){
            if(nodes[i].size() < 1) continue;

            Node* dummy = nodes[i][0];
            for(int j=1;j<nodes[i].size();j++){
                dummy->next = nodes[i][j];
                dummy = nodes[i][j];
            }
        }
        return root;
    }
private:
    vector<Node*> nodes[6001];
    void constrcture(Node* root,int deps){
        if(root == NULL) return;
        nodes[deps].push_back(root);
        constrcture(root->left, deps +1);
        constrcture(root->right , deps + 1);

    }
};
