package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayGeneratorService {


    //arr = [10, 5, 7, 6]
    //state = "0101"
    //m = 2
    //avaialble_q = [1,3]
    //blocked_q = [0, 2]

    public Integer[] generateArray(int[] arr, String state, int m) {
        Integer[] result = new Integer[m];

        StringBuilder state_sb = new StringBuilder(state);

        PriorityQueue<Integer> availableQ = new PriorityQueue<>(new AvailableComparator(arr));
        PriorityQueue<Integer> blockedQ = new PriorityQueue<>(new AvailableComparator(arr));

        for (int i = 0; i < arr.length; i++) {
            if (state.charAt(i) == '1') {
                availableQ.add(i);
            } else {
                blockedQ.add(i);
            }
        }

        if (availableQ.isEmpty()) {
            return null;
        }


        Integer biggerToBeAvailableBlocked = null;
        for (int i = 0; i < m; i++) {
            Integer available = availableQ.peek();  //6

            if (biggerToBeAvailableBlocked != null && !biggerToBeAvailableBlocked.equals(available)) {

                state_sb.setCharAt(biggerToBeAvailableBlocked, '1');
                availableQ.add(available);

                available = biggerToBeAvailableBlocked;
            }

            result[i] = arr[available];

            biggerToBeAvailableBlocked = getBiggerToBeAvailableBlocked(blockedQ, arr, available);

        }

        return result;
    }


    private int getBiggerToBeAvailableBlocked(PriorityQueue<Integer> blockedQ, int[] arr, int available) {
        PriorityQueue<Integer> blocked_swap = new PriorityQueue<>();

        if (!blockedQ.isEmpty()) {
            int prev = blockedQ.remove();   //0 -> 10

            if (blockedQ.isEmpty() && arr[prev] > arr[available]) {
                return prev;
            }

            while (!blockedQ.isEmpty() && arr[prev] > arr[available]) {
                Integer next = blockedQ.peek();
                if (Math.abs(prev - next) > 1) {
                    blockedQ.addAll(blocked_swap);
                    return prev;
                }
                blocked_swap.offer(prev);
                prev = next;
            }
        }

        return available;
    }

    class AvailableComparator implements Comparator<Integer> {
        int[] arr;

        public AvailableComparator(int[] arr) {
            this.arr = arr;
        }

        public int compare(Integer o1, Integer o2) {
            return arr[o2] - arr[o1];
        }
    }

    public static void main(String[] args) {
        ArrayGeneratorService arrayGeneratorService = new ArrayGeneratorService();
        Integer[] arr_1 = arrayGeneratorService.generateArray(new int[] {10, 5, 7, 6}, "0101", 2);
        System.out.println(Arrays.toString(arr_1));

        Integer[] arr_2 = arrayGeneratorService.generateArray(new int[] {10, 5, 7, 6}, "1111", 2);
        System.out.println(Arrays.toString(arr_2));

        Integer[] arr_3 = arrayGeneratorService.generateArray(new int[] {10, 5, 7, 6}, "0000", 2);
        System.out.println(Arrays.toString(arr_3));

        Integer[] arr_4 = arrayGeneratorService.generateArray(new int[] {10, 5, 7, 6}, "0011", 2);
        System.out.println(Arrays.toString(arr_4));

        Integer[] arr_5 = arrayGeneratorService.generateArray(new int[] {7, 10, 7, 6}, "1011", 2);
        System.out.println(Arrays.toString(arr_5));

        Integer[] arr_6 = arrayGeneratorService.generateArray(new int[] {7, 10, 7, 6}, "1011", 10);
        System.out.println(Arrays.toString(arr_6));
    }


}
