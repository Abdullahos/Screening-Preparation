package backtracking;

import java.util.ArrayList;

public class Efficencey {


    int minLength;

    private int getMinNoToRetainSameEfficence(int[] arr) {

        minLength = arr.length;

        int original_eff = 0;

        for (int i = 1; i < arr.length; i++) {
            original_eff += Math.abs(arr[i] - arr[i - 1]);
        }

        dfs(arr, new ArrayList<>(), 0, original_eff);

        return minLength;
    }

    private void dfs(int[] arr, ArrayList<Integer> list, int start, int original_eff) {
        if (list.size() >= 2) {
            int eff = calculateEff(list);
            if (eff == original_eff) {
                minLength = Math.min(minLength, list.size());
            }
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(arr, list, i + 1, original_eff);
            list.removeLast();
        }
    }

    private static int calculateEff(ArrayList<Integer> list) {
        int eff = 0;
        for (int i = 1; i < list.size(); i++) {
            eff += Math.abs(list.get(i) - list.get(i - 1));
        }
        return eff;
    }


    public static void main(String[] args) {
        Efficencey efficencey = new Efficencey();
        System.out.println(efficencey.getMinNoToRetainSameEfficence(new int[] {1,2,2,1,1}));
    }

}
