package arrays;

import java.util.PriorityQueue;

public class Sort {

    public int[] sortKMessedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }

        int i = 0;
        int idx = k;
        while (!minHeap.isEmpty() && i < arr.length && idx < arr.length) {
            minHeap.offer(arr[idx++]);
            arr[i++] = minHeap.remove();
        }

        for (; i < arr.length; i++) {
            arr[i] = minHeap.poll();
        }


        return arr;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;

        sort.sortKMessedArray(arr, k);
    }

}
