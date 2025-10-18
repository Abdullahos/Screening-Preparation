package arrays;

// https://www.tryexponent.com/practice/prepare/k-messed-array-sort

/*
Given an array of integers arr where each element is at most k places away from its sorted position,
code an efficient function sortKMessedArray that sorts arr. F
or instance, for an input array of size 10 and k = 2, an element belonging to
index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
 */
public class K_MessedSortedArray {

  // t: O(n * k), s: O(1)
  static int[] sortKMessedArray(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
      int minIdx = getMinIdx(arr, k, i);
      if (minIdx != i) {
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
      }
    }
    return arr;
  }

  static int getMinIdx(int[] arr, int k, int i) {
    int minIdx = i;
    while (++i < arr.length) {
      if (arr[i] < arr[minIdx]) {
        minIdx = i;
      }
    }
    return minIdx;
  }
}
