package arrays;

import java.util.HashMap;
import java.util.Map;

public class TotalFruits {


    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }

        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            total = Math.max(total, r - l + 1);
        }

        return total;
    }



//    //Too Complicated and not complete
//    public int totalFruitZZzzzz(int[] fruits) {
//        if (fruits.length <= 2) {
//            return fruits.length;
//        }
//
//        int j = 2;
//        int total = 2;
//
//        int[] nums = new int[] {fruits[0], fruits[1]};
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(fruits[0], 0);
//        map.put(fruits[1], 1);
//
//        while (j < fruits.length) {
//            if (map.size() == 2 && !map.containsKey(fruits[j])) {
//                if (nums[1] != fruits[j - 1]) {
//                    nums[0] = nums[1];
//                    nums[1] =  fruits[j - 1];
//                    map.put(nums[1], xxxx); //fix me
//                }
//                map.remove(nums[0]);
//                nums[0] = nums[1];
//                nums[1] = fruits[j];
//            }
//            if (!map.containsKey(fruits[j])) {
//                map.put(fruits[j], j);
//            }
//            total = Math.max(total, j - map.get(nums[0]) + 1);
//            j++;
//        }
//
//        return total;
//    }

}
