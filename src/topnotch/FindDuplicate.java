package topnotch;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for (int num : nums) {
            if (visited[num]) {
                return num;
            }
            visited[num] = true;
        }
        return -1;
    }

    //slower, the Set need to check if exists first
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for (int num : nums) {
            if (visited[num]) {
                return num;
            }
            visited[num] = true;
        }
        return -1;
    }



}
