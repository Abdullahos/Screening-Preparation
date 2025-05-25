package arrays;

public class sortArrayByKFlips {

    static int[] pancakeSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n ; i++) {
            int max_idx = getMax(arr, n - i);

            if (max_idx != n - i - 1) {
                flip(arr, max_idx + 1);
                flip(arr, n - i);
            }
        }

        return arr;
    }

    private static void flip(int[] arr, int end) {
        int i = 0, j = end - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr,  int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getMax(int[] arr, int endExc) {

        int max = arr[0], idx = 0;

        for (int i = 1; i < endExc; i++) {
            if (max < arr[i]) {
                idx = i;
                max = arr[i];
            }
        }

        return idx;
    }

}
