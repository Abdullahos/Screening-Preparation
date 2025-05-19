package arrays;

import java.util.Arrays;

/*
    [3,0,6,1,5]
    [0,1,3,5,6], ans: r


    [1,3,1]
    [1,1,3], ans [1]


    [100,200,1]
    [1,100,200] ans 2
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;

        Arrays.sort(citations);
        int i = n;

        while (i - 1 >= 0 && citations[i - 1] >=  n - i + 1) {
            i--;
        }

        return n - i;
    }

}
