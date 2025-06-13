package arrays;

public class MinNumberOfDaysToRead {


    //t: O(n), s: O(1)
    public int minPagesPerDay(int[] arr, int days) {

        int l = 0, r = days, mid;

        int minPagesPerDay = Integer.MAX_VALUE;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (canFinish(arr, mid, days)) {
                r = mid - 1;
                minPagesPerDay = mid;
            } else {
                l = mid + 1;
            }

        }

        return minPagesPerDay != Integer.MAX_VALUE ? minPagesPerDay : -1;
    }

    public boolean canFinish(int[] arr, int x, int days) {

        int i = 0;
        int acc_days = 0;
        int curr, prev = 0;

        while (i < arr.length) {
            if (prev > 0) {
                prev -= Math.min(prev, x);
                if (prev == 0) {
                    i++;
                }
            } else {
                curr = arr[i];
                curr -= Math.min(arr[i], x);

                if (curr == 0) {
                    i++;
                } else {
                    prev = curr;
                }
            }

            acc_days++;

            if (acc_days > days) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinNumberOfDaysToRead minNumberOfDaysToRead = new MinNumberOfDaysToRead();
//        System.out.println(minNumberOfDaysToRead.main(new int[]{5, 3, 4}, 5));

        System.out.println(minNumberOfDaysToRead.minPagesPerDay(new int[]{2, 3, 4, 5}, 5));
    }


}
