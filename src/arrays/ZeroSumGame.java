package arrays;
//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
public class ZeroSumGame {
    public int[] sumZero(int n) {
        int[] zeroSumNums = new int[n];
        for (int i = 0; i < n / 2 ; i++) {
            zeroSumNums[i] = i + 1;
        }

        for (int i = n / 2; i < n ; i++) {
            zeroSumNums[i] = -(i - (n / 2) + 1);
        }

        if (n % 2 != 0) {
            zeroSumNums[n - 1] = 0;
        }
        return zeroSumNums;
    }
}
