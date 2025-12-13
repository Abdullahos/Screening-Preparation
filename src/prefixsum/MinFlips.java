package prefixsum;

public class MinFlips {

  public int minFlips(int[] bits) {
    int n = bits.length;
    int[] left = new int[n];
    int[] right = new int[n];

    left[0] = 0;
    right[n - 1] = 0;

    int minFlips = 0;
    for (int i = 1; i < n; i++) {
      left[i] = bits[i] == bits[i - 1] ? left[i - 1] + 1 : i - left[i - 1] - 1;
      right[n - i - 1] = bits[n - i - 1] == bits[n - i] ? right[n - i] + 1 : i - right[n - i] - 1;
    }

    int charToFlip = 1;
    boolean flipping = false;

    for (int i = 0; i < n; i++) {
        if (flipping && bits[i] == charToFlip) {
            minFlips++;
        } else if (!flipping && i < n - 1){
            int curr_occurrences = left[i] + right[i];
            int next_occurrences = left[i + 1] + right[i + 1];

            if (bits[i] != bits[i + 1] && next_occurrences != curr_occurrences) {
                flipping = true;
                if (curr_occurrences >= next_occurrences) {
                    charToFlip ^= bits[i];
                } else {
                    charToFlip ^= bits[i + 1];
                }
            }
        }
    }

    return minFlips;
  }

  public static void main(String[] args) {
    MinFlips minFlips = new MinFlips();
    int[] bits = {0, 0, 1, 1, 0, 0};
    System.out.println("Out: " + minFlips.minFlips(bits) + " ,expected: 2");
    int[] bits2 = {0, 0, 1, 1, 1, 1};
    System.out.println("Out: " + minFlips.minFlips(bits2) + " ,expected: 0");
    int[] bits3 = {0, 0, 1, 1, 1, 0};
    System.out.println("Out: " + minFlips.minFlips(bits3) + " ,expected: 1");
  }
}
