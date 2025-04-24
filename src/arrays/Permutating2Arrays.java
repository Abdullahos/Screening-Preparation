package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/one-month-preparation-kit-two-arrays/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
public class Permutating2Arrays {

    public static boolean twoArrays(int k, List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return false;

        A.sort(Integer::compare);
        B.sort(Integer::compare);


        boolean[] taken = new boolean[A.size()];

        for (int a : A) {
            int idx = Collections.binarySearch(B, k - a);
            if (idx >= 0 && !taken[idx]) {
                taken[idx] = true;
            }
            else {
                int j;
                if (idx < 0) {
                    idx = -idx - 1;
                } else {
                    idx = Collections.binarySearch(B, k - a - 1);
                    if (idx < 0) {
                        idx = 0;
                    }
                }
                j = idx;
                for (; j < B.size(); j++) {
                    if (!taken[j] && B.get(j) + a >= k) {
                        taken[j] = true;
                        break;
                    }
                }
                if (j == B.size()) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 4, 3, 2, 1, 4, 4, 3, 2, 4);
        List<Integer> B = Arrays.asList(2, 3, 0, 1, 1, 3, 1, 0, 0, 2);

        System.out.println(twoArrays(4, A, B));
    }
}