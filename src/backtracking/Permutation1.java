package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation1 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, new ArrayList<>(), result, new HashSet<>());

        return result;

    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, Set<Integer> stk) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (stk.contains(nums[i])) {
                continue;
            }

            stk.add(nums[i]);
            list.add(nums[i]);

            dfs(nums, list, result, stk);

            list.remove(list.size() - 1);
            stk.remove(nums[i]);
        }
    }
}
