package contest.Feb489;

import java.util.*;
import java.util.stream.Collectors;

public class ToggleBulbLight {
//    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
//        Set<Integer> ons = new HashSet<>();
//
//        for (int bulb : bulbs) {
//            if (ons.contains(bulb)) {
//                ons.remove(bulb);
//            } else {
//                ons.add(bulb);
//            }
//        }
//
//        return ons.stream().sorted().collect(Collectors.toList());
//
//    }

//    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
//        TreeSet<Integer> ons = new TreeSet<>();
//
//        for (int bulb : bulbs) {
//            if (ons.contains(bulb)) {
//                ons.remove(bulb);
//            } else {
//                ons.add(bulb);
//            }
//        }
//
//        return new ArrayList<>(ons);
//    }


    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int n = 100;
        boolean[] ons = new boolean[n + 1];

        for (int bulb : bulbs) {
            ons[bulb] = !ons[bulb];
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (ons[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> valueToFreqs = new HashMap<>();
        for (int num : nums) {
            valueToFreqs.put(num, valueToFreqs.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Set<Integer>> dic = new HashMap<>();

        for (int key : valueToFreqs.keySet()) {
            int freq = valueToFreqs.get(key);

            Set<Integer> dups = dic.getOrDefault(freq, new HashSet<>());
            dups.add(key);
            dic.put(freq, dups);
        }

        Set<Integer> numsWithUniqueFreqs = dic.values()
                .stream()
                .filter(val -> val.size() == 1)
                .flatMap(Collection::stream).collect(Collectors.toSet());

        for (int num : nums) {
            if (numsWithUniqueFreqs.contains(num)) {
                return num;
            }
        }

        return -1;
    }
}
