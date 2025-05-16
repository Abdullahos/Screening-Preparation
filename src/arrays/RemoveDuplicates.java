package arrays;

public class RemoveDuplicates {

    public int removeDuplicates_simple_better(int[] nums) {
        int i = 0;  //ptr to the last unique elem
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int idx, i = 0, j = 0;
        for (idx = 0; idx < nums.length; idx++) {
            if (j >= nums.length) {
                break;
            }
            while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                j++;
            }
            j++;
            nums[idx] = nums[i];
            if (j - i > 1) {
                nums[idx + 1] = nums[i];
                idx++;
            }
            i = j;
        }
        return idx;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
