package codeguru.connect4;

public class Board {

    public enum State {
        EMPTY, PLAYER1, PLAYER2
    };

    public static int ROW_COUNT = 6;
    public static int COL_COUNT = 7;

    private State[][] board = new State[ROW_COUNT][COL_COUNT];
    private int[] next = new int[COL_COUNT];
    private State nextPlayer = State.PLAYER1;

    public Board() {
        for (int i = 0; i < ROW_COUNT; ++i) {
            for (int j = 0; j < COL_COUNT; ++j) {
                this.board[i][j] = State.EMPTY;
            }
        }
    }

    public State getState(int row, int col) {
        return board[row][col];
    }

    public boolean move(int col) {
        if (col >= 0 && col < COL_COUNT && this.next[col] < ROW_COUNT) {
            this.board[this.next[col]][col] = nextPlayer;
            ++this.next[col];

            switch (nextPlayer) {
            case PLAYER1:
                nextPlayer = State.PLAYER2;
                break;
            case PLAYER2:
                nextPlayer = State.PLAYER1;
                break;
            default:
                return false;
            }

            return true;
        }

        return false;
    }

    public boolean isWin(State player) {
        // Check rows
        for (int row = 0; row < ROW_COUNT; ++row) {
            int count = 0;
            for (int col = 0; col < COL_COUNT; ++col) {
                if (this.board[row][col] == player) {
                    ++count;

                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check columns
        for (int col = 0; col < COL_COUNT; ++col) {
            int count = 0;
            for (int row = 0; row < ROW_COUNT; ++row) {
                if (this.board[row][col] == player) {
                    ++count;

                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row < ROW_COUNT; ++row) {
            for (int col = 0; col < COL_COUNT; ++col) {
                int forwardCount = 0;
                int backCount = 0;
                for (int i = 0; i < 4; ++i) {
                    if (row + i < ROW_COUNT && col + i < COL_COUNT
                            && this.board[row + i][col + i] == player) {
                        ++forwardCount;
                    } else {
                        forwardCount = 0;
                    }

                    if (row + i < ROW_COUNT && col - i >= 0
                            && this.board[row + i][col - i] == player) {
                        ++backCount;
                    } else {
                        backCount = 0;
                    }
                }

                if (forwardCount >= 4 || backCount >= 4) {
                    return true;
                }
            }
        }

        return false;
    }
}
