package arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int k = 1;

        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return binarySearch(piles, h, 1, max);
    }

    private int binarySearch(int[] piles, int h, int l, int r) {
        if (l > r) {
            return Integer.MAX_VALUE;
        }

        int mid = l + (r - l) / 2;

        int hh = fn(piles, h, mid);

        if (hh <= h) {
            return Math.min(mid, binarySearch(piles, h, l, mid - 1));
        } else {
            return binarySearch(piles, h, mid + 1, r);
        }
    }

    private int fn(int[] piles, int h, int k) {
        int accH = 0;

        for (int p : piles) {
            accH += p / k;
            if (p % k != 0) {
                accH++;
            }
            if (accH > h) {
                return accH;
            }
        }

        return accH;
    }
}
