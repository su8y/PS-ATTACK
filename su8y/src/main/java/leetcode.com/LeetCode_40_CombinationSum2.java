package leetcode.com;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Naive하게 계산을 하게 된다면 해당 원소를 넣거나 안넣거나 2^N이다.
 * 이때 모든 경우의수를 탐색하는 것이 아닌 가지전략을 가져간다.
 */
public class LeetCode_40_CombinationSum2 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> expected = List.of(List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6));
        List<List<Integer>> actual = new LeetCode_40_CombinationSum2().combinationSum2(nums, target);
        Assertions.assertEquals(expected, actual);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort array
        var result = new ArrayList<List<Integer>>();

        dfs(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    public void dfs(int index, int[] array, int target, List<Integer> stack, List<List<Integer>> result) {
        if (target <= 0) {
            if (target == 0 && !result.contains(stack))
                result.add(List.copyOf(stack));
            return;
        }

        for (int i = index; i < array.length && array[i] <= target; i++) {
            if (i > index && array[i] == array[i - 1])
                continue;
            stack.add(array[i]);
            dfs(i + 1, array, target - array[i], stack, result);
            stack.remove(stack.size() - 1);

        }
    }
}
