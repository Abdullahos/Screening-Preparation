package arrays;
//https://leetcode.com/problems/find-the-smallest-balanced-index/
//based on the problem statement, the sum or the mult that we're looking for must fit into the sum and based on the constraints the sum will not exceed long, so we can calculate the sum freely and
//for the mult we can stop once we overflowed
public class SmallestBalancedIndex {
    public static int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return -1;
        }


        long[] sum = new long[n];
        long[] mult = new long[n];

        sum[0] = 0;
        mult[n - 1] = 1;

        boolean stopMult = false;

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (!stopMult) {
                mult[n - i - 1] = mult[n - i] * nums[n - i];
                //overflow or truncated
                if (mult[n - i - 1] <= mult[n - i] && nums[n - i] != 1) {
                    mult[n - i - 1] = 0;
                    stopMult = true;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (sum[i] == mult[i] && sum[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        smallestBalancedIndex(new int[] {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,359738368,1,536870913,262144,131072});
    }
}
