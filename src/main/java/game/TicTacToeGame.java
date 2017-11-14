package game;

import java.util.Arrays;

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

    public String play(int x, int y) {
        x--;
        y--;

        checkAxis(x, "X Axis is outside board");
        checkAxis(y, "Y Axis is outside board");

        arrangePlayer();
        setOnBoard(x, y);

        Boolean isWin = judgeWin();
        String displayInfo = buildDisplayInfo(isWin);

        return displayInfo;
    }

    private String buildDisplayInfo(Boolean isWin) {
        String displayInfo = String.format("%1$s Please Continue to play"
                , this.getNextPlayer().toString());
        if (isWin) {
            displayInfo = String.format("%1$s Win", this.currentPlayer.toString());
        }
        return displayInfo;
    }

    private Boolean judgeWin() {
        Boolean lineMatch = false;
        for (Character[] horizontalArr : this.board) {
            lineMatch = Arrays.stream(horizontalArr)
                    .allMatch(value -> value.equals(this.currentPlayer));
            if (lineMatch) {
                break;
            }
        }
        return lineMatch;
    }

    private void setOnBoard(int x, int y) {
        if (board[x][y] != emptyPlaceholder) {
            throw new RuntimeException("This place has alrealy been hold");
        }

        board[x][y] = this.currentPlayer;
    }

    private void checkAxis(int x, String message) {
        if (x < 0 || x > 3) {
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
