package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BringServerDown {

    //t: O(n), s: O(n)

    private long getMinNumberOfRequest(int[] request, int[] health, int k) {
        long totalRequest = 0;
        int requestsUnitNumber = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < request.length; i++) {

            int requestValue = request[i];
            int healthValue = health[i];

            queue.add(new Node(requestValue, getRepetitions(healthValue, k)));

            requestsUnitNumber += requestValue;
        }



        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.n--;

            totalRequest += requestsUnitNumber;

            if (node.n == 0) {
                requestsUnitNumber -= node.val;
            } else {
                queue.add(node);
            }
        }


        return totalRequest + 1;
    }


    private int getRepetitions(int health, int k) {
        return health / k + (health % k > 0 ? 1 : 0);
    }


    class Node {
        int val;
        int n;

        public Node(int val, int n) {
            this.val = val;
            this.n = n;
        }
    }

    class NodeComparator implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o2.n, o1.n);
        }
    }


    public static void main(String[] args) {
        BringServerDown brd = new BringServerDown();
        System.out.println(brd.getMinNumberOfRequest(new int[] {3,4}, new int[] {3,6}, 3));
    }
}
