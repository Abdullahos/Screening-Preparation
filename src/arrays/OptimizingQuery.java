package arrays;

import java.util.Arrays;

public class OptimizingQuery {


    //t: O(nlog(n)), s: O(1)
    public int getMaxSystemThroughput(int[] host_throughput, int k) {

        Arrays.sort(host_throughput);

        int n = host_throughput.length;

        int noOfClusters = n / k;

        int maxSystemThroughput = 0;

        for (int i = n - 2; i > n - noOfClusters; i -= 2) {
            maxSystemThroughput += host_throughput[i];
        }

        return maxSystemThroughput;
    }

}
