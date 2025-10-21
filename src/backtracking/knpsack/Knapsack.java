package backtracking.knpsack;

public class Knapsack {
  public static int knapsack(int[] weight, int[] values, int cap) {
    return backTrack(weight, values, cap, 0);
  }

  private static int backTrack(int[] weight, int[] values, int cap, int start) {
    if (cap < 0 || start == values.length) {
      return 0;
    }

    int max;

    int inc = cap - weight[start] >= 0 ? values[start] + backTrack(weight, values, cap - weight[start], start + 1) : 0;
    int exc =  backTrack(weight, values, cap, start + 1);

    max = Math.max(inc, exc);

    return Math.max(max, 0);
  }

  public static void main(String[] args) {
    int[] weights = {10, 20, 30};
    int[] values = {60, 100, 120};
    int capacity = 50;
    System.out.println("Maximum value in knapsack = " + knapsack(weights, values, capacity) + ", expected is: 220");
    int[] weights2 = {1, 1, 1};
    int[] values2 = {10, 20, 30};
    int capacity2 = 2;
    System.out.println("Maximum value in knapsack = " + knapsack(weights2, values2, capacity2) + ", expected is: 50");
    int[] weights3 = {4, 2, 3};
    int[] values3 = {10, 20, 15};
    int capacity3 = 5;
    System.out.println("Maximum value in knapsack = " + knapsack(weights3, values3, capacity3) + ", expected is: 35");
    int[] weights4 = {4, 5, 1};
    int[] values4 = {1, 2, 3};
    int capacity4 = 4;
    System.out.println("Maximum value in knapsack = " + knapsack(weights4, values4, capacity4) + ", expected is: 3");
  }
}
