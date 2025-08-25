# 21:09

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
dp = [[1e9] * (N+1) for _ in range(N+1)]
answer = [['-'] * (N+1) for _ in range(N+1)]

for _ in range(M):
    s, e, w = map(int, input().split())
    dp[s][e] = w
    dp[e][s] = w
    answer[s][e] = str(e)
    answer[e][s] = str(s)


for k in range(1, N + 1) :
    for i in range(1, N + 1) :
        for j in range(1, N + 1) :
            if i == j: continue
            if dp[i][j] > dp[i][k] + dp[k][j]:
                dp[i][j] = dp[i][k] + dp[k][j]
                answer[i][j] = answer[i][k]




for i in range(1,N+1):
    print(" ".join(answer[i][1:]))

# 21:58