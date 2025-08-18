package leetcode.com;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    private static List<List<Integer>> list = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), 0);
        return list;
    }

    public void dfs(int[] candidates, int target, List<Integer> stack, int idx) {
        if (target <= 0) {
            if (target == 0) {
                list.add(List.copyOf(stack));
            }
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            stack.add(candidates[i]);
            dfs(candidates, target - candidates[i], stack, i);
            stack.remove(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 combinationSum39 = new CombinationSum_39();

        List<List<Integer>> lists = combinationSum39.combinationSum(new int[]{2, 3, 5}, 8);

        assert lists.size() == 3;

        List<List<Integer>> expect = List.of(
                List.of(2,2,2,2),
                List.of(2,3,3),
                List.of(3,5)
        );
        Assertions.assertEquals(lists, expect);

    }
}
