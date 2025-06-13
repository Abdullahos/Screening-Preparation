package mocking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Implement the MovingAverage class:
 * <p>
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * Explanation
 * MovingAverage movingAverage = ne
 */
public class MovingAverage {

    int size;
    int sum;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        queue.add(val);

        if (queue.size() > size) {
            Integer poll = queue.remove();
            sum -= poll;
        }

        sum += val;

        return (sum * 1.0) / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);

        System.out.println(m.next(1));

        System.out.println(m.next(10));

        System.out.println(m.next(3));

        System.out.println(m.next(5));

    }
}