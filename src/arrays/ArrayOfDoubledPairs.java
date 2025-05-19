package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));

        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            //Tricky for zeros
            if (num == 0) {
                if (map.get(0) % 2 != 0) {
                    return false;
                }
                map.put(0, 0);
                continue;
            }

            Integer F = map.get(num * 2);
            Integer f = map.get(num);

            //tricky for input like [1,2,2,4,4,8]
            if (F == null || f > F) {
                return false;
            }
            map.put(num, 0);
            map.put(num * 2, F - f);
        }

        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

}
