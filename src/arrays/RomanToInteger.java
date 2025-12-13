package arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> romanCharacterMap = initRomanMap();
        int res = 0;

        int prevValue = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currValue = romanCharacterMap.get(currChar);

            if (prevValue < currValue) {
                res -= 2 * prevValue;
            }

            res += currValue;
            prevValue = currValue;
        }

        return res;
    }

    private Map<Character, Integer> initRomanMap() {
        Map<Character, Integer> romanCharacterMap = new HashMap<>();

        romanCharacterMap.put('I', 1);
        romanCharacterMap.put('V', 5);
        romanCharacterMap.put('X', 10);
        romanCharacterMap.put('L', 50);
        romanCharacterMap.put('C', 100);
        romanCharacterMap.put('D', 500);
        romanCharacterMap.put('M', 1000);

        return romanCharacterMap;
    }
}
