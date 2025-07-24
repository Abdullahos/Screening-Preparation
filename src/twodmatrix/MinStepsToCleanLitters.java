package twodmatrix;


import java.util.*;

//TODO: need more tuning
public class MinStepsToCleanLitters {

    int totalLitter = 0;
    int si = 0, sj = 0;
    Set<Cell> goodCells = new HashSet<>();
    Map<Integer, Integer> litterPosToBit = new HashMap<>();

    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int bitIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'L') {
                    litterPosToBit.put(i * cols + j, bitIndex++);
                    totalLitter++;
                } else if (c == 'S') {
                    si = i;
                    sj = j;
                }
            }
        }

        // Step 2: Precompute all goodCells (reverse DFS from L/S)
        Set<Cell> visited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'L' || c == 'S') {
                    findGoodCells(classroom, new Cell(i, j), visited, new HashSet<>());
                }
            }
        }

        // Step 3: Run DFS from start
        int result = dfs(classroom, energy, energy, si, sj, 0, 0, new HashSet<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void findGoodCells(String[] classroom, Cell current, Set<Cell> visited, Set<Cell> path) {
        int rows = classroom.length, cols = classroom[0].length();
        int i = current.i, j = current.j;

        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        char c = classroom[i].charAt(j);
        if (c == 'X' || visited.contains(current)) return;


        visited.add(current);
        path.add(current);

        if (c == 'L' || c == 'S') {
            goodCells.addAll(path);
        }

        findGoodCells(classroom, new Cell(i + 1, j), visited, path);
        findGoodCells(classroom, new Cell(i - 1, j), visited, path);
        findGoodCells(classroom, new Cell(i, j + 1), visited, path);
        findGoodCells(classroom, new Cell(i, j - 1), visited, path);
    }


    private int dfs(String[] classroom, int remainingEnergy, int maxEnergy,
                    int i, int j, int moves,
                    int collectedMask, Set<String> states) {

        int rows = classroom.length, cols = classroom[0].length();

        if (i < 0 || i >= rows || j < 0 || j >= cols || remainingEnergy < 0) {
            return Integer.MAX_VALUE;
        }

        Cell curr = new Cell(i, j);
        if (!goodCells.contains(curr)) return Integer.MAX_VALUE;

        String stateKey = i + "," + j + "," + remainingEnergy + "," + collectedMask;
        if (!states.add(stateKey)) {
            return Integer.MAX_VALUE;
        }

        char cell = classroom[i].charAt(j);

        if (cell == 'R') {
            remainingEnergy = maxEnergy;
        } else if (cell == 'L') {
            int pos = i * cols + j;
            if (litterPosToBit.containsKey(pos)) {
                int bit = litterPosToBit.get(pos);
                collectedMask |= (1 << bit);
            }
        }

        if (Integer.bitCount(collectedMask) == totalLitter) {
            states.remove(stateKey);
            return moves;
        }

        int min = Integer.MAX_VALUE;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            int next = dfs(classroom, remainingEnergy - 1, maxEnergy, ni, nj, moves + 1, collectedMask, states);
            min = Math.min(min, next);
        }

        states.remove(stateKey);
        return min;
    }

    public static void main(String[] args) {
        MinStepsToCleanLitters obj = new MinStepsToCleanLitters();
        obj.minMoves(new String[] {"LR..R", "..SLX"}, 9);
    }
}

class Cell {
    int i, j;

    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell)) return false;
        Cell other = (Cell) obj;
        return this.i == other.i && this.j == other.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}