class Solution:
    def maximumSubarray(self, arr):
        maxSum, curSum = -1e9, 0

        for i in range(len(arr)):
            if curSum + arr[i] < arr[i]:
                curSum = arr[i]
            else:
                curSum += arr[i]
            maxSum = max(maxSum, curSum)
        return maxSum
