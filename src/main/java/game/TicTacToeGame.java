package game;

import java.util.Arrays;

/**
 * Created by jxzhong on 2017/11/8.
 */
public class TicTacToeGame {


    private static final int SIZE = 3;
    private static final Character PLAYER_O = 'O';
    private static final Character PLAYER_X = 'X';
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

        for (int i = 0; i < SIZE; i++) {
            int totalOfLine = this.currentPlayer * 3;
            boolean isHorizonalAxisLineWithSamePieces = board[i][0] + board[i][1] + board[i][1] == totalOfLine;
            boolean isVerticalAxisLineWithSamePieces = board[0][i] + board[1][i] + board[2][i] == totalOfLine;
            if (isHorizonalAxisLineWithSamePieces || isVerticalAxisLineWithSamePieces) {
                lineMatch = true;
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

        if (x < 0 || x > SIZE) {
            throw new RuntimeException(message);
        }
    }

    public Character getNextPlayer() {

        return this.currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private void arrangePlayer() {
        if (!this.currentPlayer.equals(PLAYER_X)) {
            this.currentPlayer = PLAYER_X;
        } else {
            this.currentPlayer = PLAYER_O;
        }
    }
}
