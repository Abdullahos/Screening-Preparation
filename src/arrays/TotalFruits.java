package arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/

public class TotalFruits {

    public int totalFruit(int[] fruits) {
        int currNoOfFruits = 0, maxNoOfFruits = 0;
        int maxAllowedTypes = 2;
        Map<Integer, Integer> typeToLastOccrIdx = new LinkedHashMap<>();
        int i = 0, j = 0;

        while (i < fruits.length) {
            int type = fruits[i];

            if (!typeToLastOccrIdx.containsKey(type) && typeToLastOccrIdx.size() == maxAllowedTypes) {
                maxNoOfFruits = Math.max(maxNoOfFruits, currNoOfFruits);

                int typeToRemove = typeToLastOccrIdx.keySet().iterator().next();

                int lastOccIdxOfTypeToRemove = typeToLastOccrIdx.get(typeToRemove);

                currNoOfFruits -= lastOccIdxOfTypeToRemove - j + 1;

                j = lastOccIdxOfTypeToRemove + 1;

                typeToLastOccrIdx.remove(typeToRemove);
            }

            currNoOfFruits++;

            typeToLastOccrIdx.remove(type); //to rest the ordering so i can rely on iterator to get the last added (not modified)
            typeToLastOccrIdx.put(type, i);

            i++;

        }

        return Math.max(maxNoOfFruits, currNoOfFruits);
    }

    public int totalFruit2(int[] fruits) {
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
