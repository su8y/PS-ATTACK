# 22:43
import sys

input = sys.stdin.readline

T = int(input())

a, b, c = [], [], []
an, bn, cn = 0, 0, 0
answer = set()

visited = set()
count = 0


def dfs(i, i1, i2):
    global answer, count
    if (i, i1, i2) in visited: return
    visited.add((i, i1, i2))
    count += 1
    sum = a[i] + b[i1] + c[i2]
    if check(sum):
        answer.add(sum)

    if i + 1 < len(a):
        dfs(i + 1, i1, i2)
    if i1 + 1 < len(b):
        dfs(i, i1 + 1, i2)
    if i2 + 1 < len(c):
        dfs(i, i1, i2 + 1)


def check(number):
    while number > 0:
        mod = number % 10
        if not (mod == 5 or mod == 8):
            return False
        number = int(number / 10)

    return True


for _ in range(T):
    count = 0
    answer = set()
    an = int(input())
    a = list(map(int, input().split()))
    bn = int(input())
    b = list(map(int, input().split()))
    cn = int(input())
    c = list(map(int, input().split()))
    dfs(0, 0, 0)
    print(len(answer))
    print(f"count{count}")
