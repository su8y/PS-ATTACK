# 22:01

import sys

input = sys.stdin.readline
hashmap = dict()

N = int(input())

for _ in range(N):
    wordCount = [0] * 26
    word = str(input())
    for c in word.strip():
        wordCount[ord(c) - ord('a')] += 1

    key = "".join(map(str, wordCount))
    if key in hashmap:
        hashmap[key] += 1
    else:
        hashmap[key] = 0

print(len(hashmap))

# 22:21