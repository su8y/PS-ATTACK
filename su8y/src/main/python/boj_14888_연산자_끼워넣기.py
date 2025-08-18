import sys

input = sys.stdin.readline
n = int(input())

numbers = list(map(int, input().split()))
operations = list(map(int, input().split()))

min_value = int(1e9)
max_value = int(-1e9)


def dfs(target, idx, plus, minus, times, divs):
    global min_value, max_value
    if idx == n:
        min_value = min(min_value, target)
        max_value = max(max_value, target)
        return

    if plus >= 1:
        dfs(target + numbers[idx], idx + 1, plus - 1, minus, times, divs)
    if minus >= 1:
        dfs(target - numbers[idx], idx + 1, plus, minus - 1, times, divs)
    if times >= 1:
        dfs(target * numbers[idx], idx + 1, plus, minus, times - 1, divs)
    if divs >= 1:
        dfs(int(target / numbers[idx]), idx + 1, plus, minus, times, divs - 1)


dfs(numbers[0], 1, operations[0], operations[1], operations[2], operations[3])
print(max_value)
print(min_value)
