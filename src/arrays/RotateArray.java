package arrays;

public class RotateArray {

    //t: O(n), s: O(n)

    /**
     * I used this approach to avoid shifting k times as t will be t: O((n - k) * k)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if (k % n == 0) {
            return;
        }

        if (k > n) {
            k %= n; //handle when k is greater than n
        }

        int[] tmp = new int[k];

        //Always shift from end to start to avoid overwriting
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[n - k + i];
        }

        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////   ///////////////////////////////////////////////////////////////////////////////////
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        if (k % n == 0) {
            return;
        }
        if (k > n) {
            k %= n;
        }

        if (k <= n / 2) {
            for (int i = 0; i < k; i++) {
                shiftRight(nums);
            }
        }
        else {
            k = Math.abs(n - k);
            for (int i = 0; i < k; i++) {
                shiftLeft(nums);
            }
        }

    }

    private void shiftRight(int[] nums) {
        int n = nums.length;
        int tmp_last_elm = nums[n - 1];
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp_last_elm;
    }

    private void shiftLeft(int[] nums) {
        int n = nums.length;
        int tmp_first_elm = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = tmp_first_elm;
    }

    //t: , s: O(1)
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        if (k % n == 0) {
            return;
        }
        if (k > n) {
            k %= n;
        }
        for (int i = 0; i < n - k; i++) {
            nums[i + k] = nums[i];
        }
    }


}
