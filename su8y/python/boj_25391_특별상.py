import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())

m = []

for i in range(N):
    a, b = map(int, input().split())
    m.append((a, b))

m.sort(key=lambda x: -x[1])
sortedM = sorted(m[K:], key=lambda x: -x[0])

answer = 0
for i in range(K):
    answer += m[i][0]

for i in range(0, M):
    answer += sortedM[i][0]

print(answer)