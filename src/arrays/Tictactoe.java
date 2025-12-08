package arrays;

public class Tictactoe {
    private static final String A = "A";
    private static final String B = "B";
    private static final int size = 3;

    public String tictactoe(int[][] moves) {
        PlayerTracker playerA = new PlayerTracker();
        PlayerTracker playerB = new PlayerTracker();

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0 && playerA.add(moves[i][0], moves[i][1])) {
                return A;
            } else if (i % 2 != 0 && playerB.add(moves[i][0], moves[i][1])) {
                return B;
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    class PlayerTracker {
        int[] rows;
        int[] columns;
        int[] diagonal;
        boolean winner;

        public PlayerTracker() {
            rows = new int[3];
            columns = new int[3];
            diagonal = new int[2];
            winner = false;
        }

        public boolean add(int x, int y) {
            if (++rows[x] == size) {
                winner = true;
            }

            if (++columns[y] == size) {
                winner = true;
            }
            if (x == y && ++diagonal[0] == size) {
                winner = true;
            }
            if (x + y == 2 && ++diagonal[1] == size) {
                winner = true;
            }
            return winner;
        }
    }
}
