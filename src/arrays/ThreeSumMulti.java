package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
  
 -----------------------------------------------------
 
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation: 
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 */
public class ThreeSumMulti {
    //brute force n^3
    public int threeSumMulti_Brute_Force(int[] arr, int target) {
        int modulo = (int) (Math.pow(10, 9)) + 7;
        int n = arr.length;
        int counts = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        counts++;
                        counts %= modulo;
                    }
                }
            }
        }
        return counts;
    }

    //O(n^2)
    public int threeSumMulti_Two_Pointers(int[] arr, int target) {
        int modulo = (int) (Math.pow(10, 9)) + 7;
        int length = arr.length;
        int counts = 0;
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
        }
        for (int i = 0; i < length - 2; i++) {
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    if (arr[l] == arr[r]) {
                        int n = r - l + 1;
                        counts += ((n - 1) * n / 2);
                        counts %= modulo;
                        break;
                    } else {
                        boolean isHeadIsLeft = arr[l] == arr[i];
                        boolean isHeadIsRight = arr[r] == arr[i];

                        int countsLeft = map.get(arr[l]);
                        int countsRight = map.get(arr[r]);

                        if (isHeadIsLeft) {
                            countsLeft--;
                        }
                        if (isHeadIsRight) {
                            countsRight--;
                        }
                        counts += countsLeft * countsRight;
                        counts %= modulo;

                        l += countsLeft;
                        r -= countsRight;
                    }
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
            map.put(arr[i], map.get(arr[i]) - 1);   //the tricky part
        }
        return counts;
    }

    public static void main(String[] args) {
        ThreeSumMulti threeSumMulti = new ThreeSumMulti();
        System.out.println(threeSumMulti.threeSumMulti_Two_Pointers(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }
}
