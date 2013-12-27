package codeguru.connect4;

import codeguru.connect4.Board.State;

public class ComputerPlayer implements Player {

    public static final int MAX_DEPTH = 6;
    public static final int[] MOVE_ORDER = new int[]{3, 2, 4, 1, 5, 0, 6};

    private State me = null;
    private State opponent = null;

    public ComputerPlayer(State me) {
        this.me = me;

        switch (this.me) {
        case PLAYER1:
            this.opponent = State.PLAYER2;
            break;

        case PLAYER2:
            this.opponent = State.PLAYER1;
            break;

        default:
            break;
        }
    }

    @Override
    public int move(Board b) {
        int best = Integer.MIN_VALUE;
        int move = -1;

        for (int i = 0; i < Board.COL_COUNT; ++i) {
            Board next = new Board(b);

            if (next.canMove(MOVE_ORDER[i])) {
                next.move(MOVE_ORDER[i]);

                int val = minMax(next, MAX_DEPTH, false);

                if (val > best) {
                    best = val;
                    move = MOVE_ORDER[i];
                }
            }
        }

        return move;
    }

    private int minMax(Board b, int depth, boolean maximizing) {
        if (depth == 0) {
            return evaluate(b);
        }

        if (b.isWin(this.me)) {
            return Integer.MAX_VALUE;
        }

        if (b.isWin(this.opponent)) {
            return Integer.MIN_VALUE;
        }

        if (maximizing) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < Board.COL_COUNT; ++i) {
                Board next = new Board(b);

                if (next.canMove(MOVE_ORDER[i])) {
                    next.move(MOVE_ORDER[i]);

                    int val = minMax(next, depth - 1, false);
                    best = Math.max(best, val);
                }
            }

            return best;
        } else {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < Board.COL_COUNT; ++i) {
                Board next = new Board(b);

                if (next.canMove(MOVE_ORDER[i])) {
                    next.move(MOVE_ORDER[i]);

                    int val = minMax(next, depth - 1, true);
                    best = Math.min(best, val);
                }
            }

            return best;
        }
    }

    private int evaluate(Board b) {
        if (b.isWin(this.me)) {
            return Integer.MAX_VALUE;
        } else if (b.isWin(this.opponent)) {
            return Integer.MIN_VALUE;
        }

        return 0;
    }

}
