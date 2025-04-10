package arrays;

public class X {
    public int trap(int[] height) {
        int l = 1, r = 3, water = 0;
        int n = height.length;

        while (l < r && r < n) {
            boolean entered = false;
            while (l + 1 < n && height[l] >= height[l + 1]) {
                l++;
                entered = true;
            }
            if (l == n) {
                break;
            }
            if (entered) {
                r = l + 1;
                l = l - 1;
            }
            water += Math.min(height[l], height[r]) * (r - l - 1);
            l = r;
            r = l + 2;
        }
        return water;
    }

    public static void main(String[] args) {
        X x = new X();
        System.out.println(x.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
