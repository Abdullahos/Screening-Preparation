package tests.ibm.dec2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxManagerMeetingScore {

//    public int getMax(List<Integer> meetingScore) {
//        meetingScore.sort(Integer::compareTo);
//        int counts = 0;
//        int score = 0;
//
//        for (int i = 1; i < meetingScore.size(); i++) {
//            score += meetingScore.get(i);
//            if (score > 0) {
//                counts++;
//            }
//        }
//
//        return counts;
//    }

    public int getMax(List<Integer> meetingScore) {
        List<Integer> neg = new ArrayList<>();
        int sum = 0;

        for (Integer integer : meetingScore) {
            if (integer < 0) {
                neg.add(integer);
            }
            sum += integer;
        }

        if (sum > 0) {
            return meetingScore.size();
        }
        int counts = meetingScore.size();
        neg.sort(Collections.reverseOrder());
        for (int num : neg) {
            counts--;
            sum -= num;
            if (sum > 0) {
                return counts;
            }
        }
        return -1;
    }

}
