package queue;

import java.util.*;

public class TopKfreqNums {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> q = new PriorityQueue<>(k, new TopFreqComparator(freqs));
        for (int num : freqs.keySet()) {
            q.offer(num);
            if (q.size() > k) {
                q.remove();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.remove();
        }
        return ans;
    }
}

class TopFreqComparator implements Comparator<Integer> {

    Map<Integer, Integer> freqs;
    public TopFreqComparator(Map<Integer, Integer> freqs) {
        this.freqs = freqs;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return freqs.get(o1) - freqs.get(o2);
    }
}