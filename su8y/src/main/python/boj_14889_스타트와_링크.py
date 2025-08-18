from main import matrix, N


class Solution:
    minValue = 1e9
    matrix = None
    persons = None

    # 선택한 개수, 마지막 선택 인덱스, 방문체크 배열
    def calc(self, s):
        score = 0
        for i in s:
            for j in s:
                score += matrix[i][j]
        return score

    def dfs(self, selected, x, visited):
        if len(selected) == self.N / 2:
            a = self.calc(selected)
            b = self.calc(self.persons - selected)
            self.minValue = min(self.minValue, abs(a - b))
            return

        for i in range(x, N):
            if visited[i]: continue
            visited[i] = True
            selected.add(i)
            self.dfs(selected, i + 1, visited)
            selected.remove(i)
            visited[i] = False

    def minimumScore(self, N, matrix):
        visited = [False] * N
        self.N = N
        self.persons = set(i for i in range(0, N))

        self.dfs(set(), 0, visited)

        return self.minValue
