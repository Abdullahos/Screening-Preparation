package arrays;

//https://leetcode.com/problems/sign-of-the-product-of-an-array
public class SignArray {

    public int arraySign(int[] nums) {
        int countNeg = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                countNeg++;
            }
        }

        return countNeg % 2 == 0 ? 1 : -1;
    }

    private int signFunc(int x) {
        return switch (x) {
            case 0 -> 0;
            default -> {
                if (x < 1)
                    yield 1;
                else if (x > 1)
                    yield -1;
                else
                    yield 0;
            }
        };
    }
}
