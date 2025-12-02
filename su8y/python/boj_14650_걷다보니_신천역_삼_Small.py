# 22:36 -> 22:41
import sys
input = sys.stdin.readline().rstrip

N = int(input())
answer = 0

def backtracking(string, depth):
    global answer
    if depth == N:
        if string[0] != '0' and int(string) % 3 == 0:
            answer += 1
        return
    for i in range(3):
        backtracking(string + str(i), depth + 1)

backtracking("", 0)
print(answer)