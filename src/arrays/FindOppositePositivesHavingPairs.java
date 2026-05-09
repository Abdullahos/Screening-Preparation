package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOppositePositivesHavingPairs {

    public static List<Integer> findPairs(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> res_map = new HashMap<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (num != 0 && map.containsKey(-num)) {
                int pos = Math.abs(num);
                int neg = -pos;
                int commonFreq = Math.min(map.get(pos), map.get(neg));

                if (res_map.getOrDefault(pos, 0) < commonFreq) {
                    res.add(pos);
                    res_map.put(pos, res_map.getOrDefault(pos, 0) + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,-3,6,-3,3,-6,0,0, 3,-3,3,-3};
        List<Integer> pairs = findPairs(nums);
        System.out.println(pairs);
    }

}
