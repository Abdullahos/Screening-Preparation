package tests.ibm.valentine26XD;

public class MinTeamNo {
    //THIS ONE IS LOGICALLY WRONG AND PRODUCE WRONG ANSWERS. ie. 5, 3, 11 -> -1
    private int getMinTeamNo(int team_1, int team_2, int p) {
        if (p % Math.max(team_1, team_2) == 0) {
            return p / Math.max(team_1, team_2);
        }

        if (p < Math.min(team_1, team_2)) {
            return -1;
        }

        int rem = p % Math.max(team_1, team_2);

        while (Math.min(team_1, team_2) % rem != 0 && Math.max(team_1, team_2) % (p - rem) != 0 && rem < p) {
            rem += Math.min(team_1, team_2);
        }

        if (rem < p) {
            return (Math.min(team_1, team_2) % rem == 0 && Math.max(team_1, team_2) % (p - rem) == 0) ?
                    Math.min(team_1, team_2) / rem  + Math.max(team_1, team_2) / (p - rem) : -1;
        }

        return rem % Math.min(team_1, team_2) == 0 ? p / Math.min(team_1, team_2) : -1;
    }

    private int bruteForce(int team_1, int team_2, int p) {
        if (p % Math.max(team_1, team_2) == 0) {
            return p / Math.max(team_1, team_2);
        }

        if (p < Math.min(team_1, team_2)) {
            return -1;
        }

        return bruteForce_helper(Math.max(team_1, team_2), Math.min(team_1, team_2), p);

    }

    private int bruteForce_helper(int team_1, int team_2, int p) {
        if (p < 0) {
            return -1;
        }

        if (p == 0) {
            return 0;
        }

        int t1 = bruteForce_helper(team_1, team_2, p - team_1);
        if (t1 != -1) {
            return t1 + 1;
        }

        int t2 = bruteForce_helper(team_1, team_2, p - team_2);
        if (t2 != -1) {
            return t2 + 1;
        }

        return -1;
    }

    private int clever_mathimatical_sol(int team_1, int team_2, int p) {
        int small = Math.min(team_1, team_2);
        int big = Math.max(team_1, team_2);

        int min = Integer.MAX_VALUE;
        for (int x = p / big; x >= 0; x--) {
            int rem = p % big;
            if (rem % small == 0) {
                int y = rem / small;
                min = Math.min(min, x + y);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
