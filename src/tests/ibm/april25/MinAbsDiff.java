package tests.ibm.april25;

import java.util.Collections;
import java.util.List;

public class MinAbsDiff {

    public int minAbsDiff(List<Integer> list) {
        int min = 0;
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            min += Math.abs(list.get(i) - list.get(i - 1));
        }
        return min;
    }

}
