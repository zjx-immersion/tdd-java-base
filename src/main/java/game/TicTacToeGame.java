package game;

/**
 * Created by jxzhong on 2017/11/8.
 */
public class TicTacToeGame {


    private Character emptyPlaceholder = '\0';
    private Character[][] board = {{emptyPlaceholder, emptyPlaceholder, emptyPlaceholder},
            {emptyPlaceholder, emptyPlaceholder, emptyPlaceholder},
            {emptyPlaceholder, emptyPlaceholder, emptyPlaceholder}};

    public TicTacToeGame() {
    }

    public void play(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X is outside board");
        } else if (y < 1 || y > 3) {
            throw new RuntimeException("Y is outside board");
        }

        if(board[x][y] != emptyPlaceholder){
            throw new RuntimeException("This place has alrealy been hold");
        }

        board[x][y] = 'X';
    }
}
