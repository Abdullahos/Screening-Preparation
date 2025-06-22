package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AnyPrimeFreq {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Optional<Integer> anyPrim = freq.values().stream().filter(this::isPrime).findAny();

        return anyPrim.isPresent();
    }

    private boolean isPrime(int freq) {
        if (freq < 2)    return false;

        for (int domin = 2; domin <= Math.sqrt(freq); domin++) {
            if (freq % domin == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        AnyPrimeFreq anyPrimeFreq = new AnyPrimeFreq();
        System.out.println(anyPrimeFreq.checkPrimeFrequency(new int[] {1,2,3,4,5}));
    }
}
