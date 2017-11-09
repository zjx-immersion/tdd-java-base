package game;

/**
 * Created by jxzhong on 2017/11/8.
 */
public class TicTacToeGame {


    private Character emptyPlaceholder = '\0';
    private Character[][] board = {{emptyPlaceholder, emptyPlaceholder, emptyPlaceholder},
            {emptyPlaceholder, emptyPlaceholder, emptyPlaceholder},
            {emptyPlaceholder, emptyPlaceholder, emptyPlaceholder}};
    private Character currentPlayer = '\0';

    public TicTacToeGame() {
    }

    public void play(int x, int y) {
        checkAxis(x, "X is outside board");
        checkAxis(y, "Y is outside board");

        arrangePlayer();
        setOnBoard(board[x], y);
    }

    private void setOnBoard(Character[] characters, int y) {
        if (characters[y] != emptyPlaceholder) {
            throw new RuntimeException("This place has alrealy been hold");
        }

        characters[y] = 'X';
    }

    private void checkAxis(int x, String message) {
        if (x < 1 || x > 3) {
            throw new RuntimeException(message);
        }
    }

    public Character getNextPlayer() {
        return this.currentPlayer.equals('X') ? 'O' : 'X';
    }

    private void arrangePlayer() {
        if ('X' != this.currentPlayer) {
            this.currentPlayer = 'X';
        } else {
            this.currentPlayer = 'O';
        }
    }
}
