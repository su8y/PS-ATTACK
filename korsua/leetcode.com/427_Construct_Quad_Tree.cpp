/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;

    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node*
_bottomLeft, Node* _bottomRight) { val = _val; isLeaf = _isLeaf; topLeft =
_topLeft; topRight = _topRight; bottomLeft = _bottomLeft; bottomRight =
_bottomRight;
    }
};
*/

class Solution {
public:
    Node* construct(vector<vector<int>>& grid) {
        return divideAndConquer(0, 0, grid.size(), grid);
    }
private:
    /* 분할정복으로 4방향의 재귀 호출을 한다. */ 
    Node* divideAndConquer(int y, int x, int size, vector<vector<int>>& grid) {
        Node* head = new Node();
        head->isLeaf = 1;
        head->val = grid[y][x];
        if (size == 1)
            return head;

        for (int i = y; i < y + size; i++)
            for (int j = x; j < x + size; j++)
                if (grid[i][j] != grid[y][x]) {
                    int midY = y + size / 2;
                    int midX = x + size / 2;
                    head->isLeaf = 0;
                    head->topLeft = divideAndConquer(y, x, size / 2, grid);
                    head->topRight = divideAndConquer(y, midX, size / 2, grid);
                    head->bottomLeft = divideAndConquer(midY, x, size / 2, grid);
                    head->bottomRight = divideAndConquer(midY, midX, size / 2, grid);
                    if(head->topLeft->val == 1 ||
                        head->topRight->val == 1 ||
                        head->bottomLeft->val == 1 ||
                        head->bottomRight->val == 1 
                    )head->val = 1;


                    return head;
                }

        return head;
    }
};
