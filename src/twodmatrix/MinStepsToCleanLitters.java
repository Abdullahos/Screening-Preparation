package twodmatrix;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO: need more tuning
public class MinStepsToCleanLitters {

    int totalLitter = 0;
    Map<Integer, Integer> litterPosToBit = new HashMap<>(); // map (i * cols + j) -> bit index

    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int si = 0, sj = 0;
        int bitIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cell = classroom[i].charAt(j);
                if (cell == 'S') {
                    si = i;
                    sj = j;
                } else if (cell == 'L') {
                    litterPosToBit.put(i * cols + j, bitIndex++);
                    totalLitter++;
                }
            }
        }

        int result = dfs(classroom, energy, energy, si, sj, 0, 0, new HashSet<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String[] classroom, int remainingEnergy, int energy,
                    int i, int j, int moves,
                    int collectedMask, Set<String> states) {

        int rows = classroom.length, cols = classroom[0].length();

        if (i < 0 || i >= rows || j < 0 || j >= cols || classroom[i].charAt(j) == 'X' || remainingEnergy < 0) {
            return Integer.MAX_VALUE;
        }

        String stateKey = remainingEnergy + "," + collectedMask + "," + i + "," + j;
        if (!states.add(stateKey)) {
            return Integer.MAX_VALUE;
        }

        char cell = classroom[i].charAt(j);

        if (cell == 'R') {
            remainingEnergy = energy; // recharge
        }

        if (cell == 'L') {
            int pos = i * cols + j;
            int bit = litterPosToBit.get(pos);
            if ((collectedMask & (1 << bit)) == 0) {
                collectedMask |= (1 << bit);
            }
        }

        if (Integer.bitCount(collectedMask) == totalLitter) {
            states.remove(stateKey);
            return moves;
        }

        int min = Integer.MAX_VALUE;
        // Down, Up, Left, Right
        min = Math.min(min, dfs(classroom, remainingEnergy - 1, energy, i + 1, j, moves + 1, collectedMask, states));
        min = Math.min(min, dfs(classroom, remainingEnergy - 1, energy, i - 1, j, moves + 1, collectedMask, states));
        min = Math.min(min, dfs(classroom, remainingEnergy - 1, energy, i, j - 1, moves + 1, collectedMask, states));
        min = Math.min(min, dfs(classroom, remainingEnergy - 1, energy, i, j + 1, moves + 1, collectedMask, states));

        states.remove(stateKey);

        return min;
    }

    public static void main(String[] args) {
        MinStepsToCleanLitters obj = new MinStepsToCleanLitters();
        obj.minMoves(new String[] {"LR..R", "..SLX"}, 9);
    }
}
