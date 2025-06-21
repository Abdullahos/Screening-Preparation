package twodmatrix;


//TODO: need more tuning
public class MinStepsToCleanLitters {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length, m = classroom[0].length();

        //find the s
        int litters = 0;
        int si = 0, sj = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    si = i;
                    sj = j;
                } else if (c == 'L') {
                    litters++;
                }
            }
        }

        //discover all possibilites dfs and get the min moves or -1
        int minSteps = dfs(classroom, si, sj, n, m, energy, energy, 0, new boolean[n][m], litters, 0);

        return  minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }

    int dfs(String[] classroom, int r, int c, int n, int m, int energy, int accEnergy, int steps, boolean[][] visited, int litters, int accLitters) {
        if (r == n || r == -1 || c == m || c == -1 || visited[r][c] || classroom[r].charAt(c) == 'X') {
            return Integer.MAX_VALUE;
        }

        char car = classroom[r].charAt(c);

        if (car == 'R') {
            accEnergy = energy + 1;
        } else if (car == 'L') {
            accLitters++;
        }

        if (accLitters == litters) {
            return steps;
        }

        if (accEnergy == -1) {
            return Integer.MAX_VALUE;
        }

        visited[r][c] = true;

        int down = dfs(classroom, r + 1, c, n, m, energy, accEnergy - 1, steps + 1, visited.clone(), litters, accLitters);
        int up = dfs(classroom, r - 1, c, n, m, energy, accEnergy - 1, steps + 1, visited.clone(), litters, accLitters);
        int left = dfs(classroom, r, c - 1, n, m, energy, accEnergy - 1, steps + 1, visited.clone(), litters, accLitters);
        int right = dfs(classroom, r, c + 1, n, m, energy, accEnergy - 1, steps + 1, visited.clone(), litters, accLitters);

        return Math.min(down, Math.min(up, Math.min(left, right)));
    }
}
