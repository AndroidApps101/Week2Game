package codeguru.connect4;

import codeguru.connect4.Board.State;

public class ComputerPlayer implements Player {

    public static final int MAX_DEPTH = 5;
    public static final int[] MOVE_ORDER = new int[] { 3, 2, 4, 1, 5, 0, 6 };

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
            State player = MAX_DEPTH % 2 == 0 ? this.opponent : this.me;
            
            return evaluate(b, player);
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

    private int evaluate(Board b, State who) {
        if (b.isWin(this.me)) {
            return Integer.MAX_VALUE;
        } else if (b.isWin(this.opponent)) {
            return Integer.MIN_VALUE;
        }

        int score = 10 * twoInARow(b, who) + 1000 * threeInARow(b, who);
        return who == this.me ? score : -score;
    }

    private int twoInARow(Board b, State who) {
        int twoInARowCount = 0;

        // Check rows
        for (int row = 0; row < Board.ROW_COUNT - 1; ++row) {
            for (int col = 0; col < Board.COL_COUNT - 1; ++col) {
                if (b.getState(row, col) == who
                        && b.getState(row + 1, col) == who) {
                    ++twoInARowCount;
                }
            }
        }

        // Check cols
        for (int row = 0; row < Board.ROW_COUNT - 1; ++row) {
            for (int col = 0; col < Board.COL_COUNT - 1; ++col) {
                if (b.getState(row, col) == who
                        && b.getState(row, col + 1) == who) {
                    ++twoInARowCount;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row < Board.ROW_COUNT - 1; ++row) {
            for (int col = 0; col < Board.COL_COUNT - 1; ++col) {
                if (b.getState(row, col) == who
                        && b.getState(row + 1, col + 1) == who) {
                    ++twoInARowCount;
                }
            }
        }

        for (int row = 0; row < Board.ROW_COUNT - 1; ++row) {
            for (int col = 1; col < Board.COL_COUNT; ++col) {
                if (b.getState(row, col) == who
                        && b.getState(row + 1, col - 1) == who) {
                    ++twoInARowCount;
                }
            }
        }

        return twoInARowCount;
    }

    private int threeInARow(Board b, State who) {
        int threeInARowCount = 0;
        
        // Check rows
        for (int row = 0; row < Board.ROW_COUNT; ++row) {
            int count = 0;
            for (int col = 0; col < Board.COL_COUNT; ++col) {
                if (b.getState(row, col) == who) {
                    ++count;

                    if (count == 3) {
                        ++threeInARowCount;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check columns
        for (int col = 0; col < Board.COL_COUNT; ++col) {
            int count = 0;
            for (int row = 0; row < Board.ROW_COUNT; ++row) {
                if (b.getState(row, col) == who) {
                    ++count;

                    if (count == 3) {
                        ++threeInARowCount;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row < Board.ROW_COUNT; ++row) {
            for (int col = 0; col < Board.COL_COUNT; ++col) {
                int forwardCount = 0;
                int backCount = 0;
                for (int i = 0; i < 4; ++i) {
                    if (row + i < Board.ROW_COUNT && col + i < Board.COL_COUNT
                            && b.getState(row + i, col + i) == who) {
                        ++forwardCount;
                    } else {
                        forwardCount = 0;
                    }

                    if (row + i < Board.ROW_COUNT && col - i >= 0
                            && b.getState(row + i, col - i) == who) {
                        ++backCount;
                    } else {
                        backCount = 0;
                    }
                }

                if (forwardCount == 3) {
                    ++threeInARowCount;
                }

                if (backCount == 3) {
                    ++threeInARowCount;
                }
            }
        }

        return threeInARowCount;
    }

}
