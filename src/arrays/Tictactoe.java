package arrays;

public class Tictactoe {
    private static final String A = "A";
    private static final String B = "B";


    public String tictactoe(int[][] moves) {
        char[][] normalizedMoves = new char[3][3];

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            normalizedMoves[x][y] = i % 2 == 0 ? 'X' : 'O';
        }

        String winner = judge_horizontal(normalizedMoves);
        if (winner != null) return winner;

        winner = judge_vertical(normalizedMoves);
        if (winner != null) return winner;

        winner = judge_right_diagonal(normalizedMoves);
        if (winner != null) return winner;

        winner = judge_left_diagonal(normalizedMoves);
        if (winner != null) return winner;

        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private String judge_horizontal(char[][] normalizedMoves) {
        for (int i = 0; i < 3; i++) {
            int x_counts = 0, o_counts = 0;
            for (int j = 0; j < 3; j++) {
                char curr_play = normalizedMoves[i][j];
                if (curr_play == 'X') {
                    x_counts++;
                } else if (curr_play == 'O') {
                    o_counts++;
                }
                if (x_counts == 3) return A;
                if (o_counts == 3) return B;
            }
        }
        return null;
    }

    private String judge_vertical(char[][] normalizedMoves) {
        for (int i = 0; i < 3; i++) {
            int x_counts = 0, o_counts = 0;
            for (int j = 0; j < 3; j++) {
                char curr_play = normalizedMoves[j][i];
                if (curr_play == 'X') {
                    x_counts++;
                } else if (curr_play == 'O') {
                    o_counts++;
                }
                if (x_counts == 3) return A;
                if (o_counts == 3) return B;
            }
        }
        return null;
    }

    private String judge_right_diagonal(char[][] normalizedMoves) {
        int x_counts = 0, o_counts = 0;
        for (int i = 0; i < 3; i++) {
            char curr_play = normalizedMoves[i][i];
            if (curr_play == 'X') {
                x_counts++;
            } else if (curr_play == 'O') {
                o_counts++;
            }
            if (x_counts == 3) return A;
            if (o_counts == 3) return B;
        }
        return null;
    }

    private String judge_left_diagonal(char[][] normalizedMoves) {
        int x_counts = 0, o_counts = 0;
        for (int i = 0; i < 3; i++) {
            char curr_play = normalizedMoves[i][2 - i];
            if (curr_play == 'X') {
                x_counts++;
            } else if (curr_play == 'O') {
                o_counts++;
            }
            if (x_counts == 3) return A;
            if (o_counts == 3) return B;
        }

        return null;
    }
}
