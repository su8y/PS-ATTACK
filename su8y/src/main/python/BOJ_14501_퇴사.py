class Solution:
    def init(self):
        return

    # arr: List<Int,Int>
    def solution(self, n: int, arr: list):
        cache = [0] * (n + 1)
        for i in range(1, n + 1):
            time, cost = arr[i]
            cache[i] = max(cache[i], cache[i - 1])

            idx = i - 1 + time
            if idx > n: continue
            cache[idx] = max(cache[idx], cost + cache[i - 1])

        return cache[n]
