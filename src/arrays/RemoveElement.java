package arrays;

public class RemoveElement {
    //Space O(1), time O(n)
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length)  {
            if (nums[j] == val) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            j++;
            i++;
        }
        return i;
    }

    //More Intuitive Sol
    public int removeElement_2(int[] nums, int val) {
        int n = nums.length;
        int r = n - 1;
        int counts = 0;

        for (int l = 0; l < n; l++) {
            if (nums[l] == val) {
                counts++;
                while (r >= 0 && nums[r] == val) {
                    r--;
                }
                if (r >= 0) {
                    nums[l] = nums[r];
                    r--;
                }
            }
        }

        return n - counts;
    }

}
