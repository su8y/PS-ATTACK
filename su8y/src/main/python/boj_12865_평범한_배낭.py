class Knapsack:
    def solution0_1(self, w: list, v: list, K: int):
        N = len(w)
        dp = [[0] * (K + 1) for _ in range(N + 1)]  # [N+1][K+1]

        for i in range(0, N):
            for j in range(0, K + 1):
                # j크기 == i번째 물건의 크기 ; 즉 최초
                # 2. j크기가 i번째 물건의 크기를 포함하는 크기인경우 즉 최초가 아님 and 사전에 j - w[i]의 값이 있다면
                if j == w[i] or (j > w[i] and dp[i][j - w[i]] > 0):
                    dp[i + 1][j] = max(dp[i][j], dp[i][j - w[i]] + v[i])  # i번째를 넣는경우
                else:
                    dp[i + 1][j] = dp[i][j]
        return max(dp[N])
