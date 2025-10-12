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
    int maxCitationsPerPapar = 1000;

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

    //Using count sort, Bucket sort
    //optimized version of v3
    public int hIndex2(int[] citations) {
        int n = citations.length;
        if (n == 0)
            return 0;
        int[] counts = new int[n + 1];

        for (int citation : citations) {
            if (citation > n) {
                counts[n]++;
            } else {
                counts[citation]++;
            }
        }

        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += counts[i];
            if (total >= i) {
                return i;   //early return for the max i- > max H
            }
        }

        return 0;
    }

    public int hIndex3(int[] citations) {

        int n = citations.length;
        int[] arr = new int[maxCitationsPerPapar + 1];

        for (int cit : citations) {
            for (int i = cit; i >= 0; i--) {
                arr[i]++;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= i) {
                return i;
            }
        }

        return 0;
    }

    public int optimizedHIndex3(int[] citations) {

        int n = citations.length;
        int[] arr = new int[maxCitationsPerPapar + 1];

        for (int cit : citations) {
            arr[cit]++;
        }

        int total = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            total += arr[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }

}

