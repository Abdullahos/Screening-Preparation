package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        // O(nlog(n))
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); //O(log(n))
            String sortedKey = new String(chars);   //O(n)
            List<String> values = map.get(sortedKey);
            if (values == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedKey, list);
            }
            else {
                values.add(s);
            }
        }

        return map.values().stream().toList();
    }
}
