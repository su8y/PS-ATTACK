class Solution:
    directions = [
        [1, 1], [1, 0], [0, 1], [-1, -1], [-1, 0], [0, -1], [1, -1], [-1, 1]
    ]

    '''
    deadtree 반환
    나무는 양분을 흡수하여 사이즈가 커진다.
    '''

    def spring(self, matrix, tree_map):
        dead_trees = list()

        for i in range(len(tree_map)):
            for j in range(len(tree_map)):
                alive_tree = []
                for k in range(len(tree_map[i][j])):
                    if tree_map[i][j][k] <= matrix[i][j]:
                        matrix[i][j] -= tree_map[i][j][k]  # 양분 먹고
                        alive_tree.append(tree_map[i][j][k] + 1)  # 나무 증가
                    else:
                        dead_trees.append((i, j, tree_map[i][j][k]))  # [i][j] k번째 인덱스 제거 해라
                # 나무 죽여버리기
                tree_map[i][j] = alive_tree

        return dead_trees

    '''
    죽은 나무가 양분을 매트릭스의 추가한다.
    '''

    def summer(self, matrix, dead_trees):
        if not dead_trees: return
        for y, x, size in dead_trees:
            matrix[y][x] += size // 2

    '''
    사이즈가 5인 나무가 주변 매트릭스에 증분한다.
    '''

    def maple(self, trees):
        new_tree = [[list() for _ in range(len(trees))] for _ in range(len(trees))]
        for i in range(len(trees)):
            for j in range(len(trees)):
                for k in range(len(trees[i][j])):
                    if trees[i][j][k] % 5 == 0:
                        for dy, dx in self.directions:
                            ny = i + dy
                            nx = j + dx
                            if not (0 <= ny < len(trees) and 0 <= nx < len(trees)): continue
                            new_tree[ny][nx].append(1)
        for i in range(len(trees)):
            for j in range(len(trees)):
                trees[i][j] = new_tree[i][j] + trees[i][j]

    def winter(self, matrix, food):
        for i in range(len(food)):
            for j in range(len(food[0])):
                matrix[i][j] += food[i][j]

    def aliveCountAfterYear(self, K, matrix, trees, food):
        for i in range(K):
            dead_trees = self.spring(matrix, trees)  # 양분 섭취 못먹으면 죽음
            self.summer(matrix, dead_trees)  # 죽은 나무 양분으로 변화
            self.maple(trees)  # 5의 배수 나무가 번식 -> 1
            self.winter(matrix, food)  # 땅에 양분을 추가

        count = 0
        for row in trees:
            for col in row:
                count += len(col)
        return count
