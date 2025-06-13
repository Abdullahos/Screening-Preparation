package arrays;

public class MinSwaps {

    private int minSwaps(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;

        int min_idx = 0, max_idx = n - 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[max_idx]) {
                max_idx = i;
            }
            else if (arr[i] < arr[min_idx]) {
                min_idx = i;
            }
        }

        int swaps = 0;

        if (min_idx != 0) {
            swaps = min_idx;
            if (max_idx != n - 1 && min_idx > max_idx) {
                swaps += n - (max_idx + 1) - 1;
            }
        } else if (max_idx != n - 1) {
            swaps = n - (max_idx + 1);
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();

        System.out.println(minSwaps.minSwaps(new int[]{2, 4, 3, 1, 6}));

        System.out.println(minSwaps.minSwaps(new int[]{1, 4, 3, 2, 6}));

        System.out.println(minSwaps.minSwaps(new int[]{3, 2, 1}));

    }

}
