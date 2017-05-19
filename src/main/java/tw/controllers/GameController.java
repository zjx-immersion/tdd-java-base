package tw.controllers;

import tw.Game;
import tw.commands.InputCommand;
import tw.model.GuessResult;
import tw.views.GameView;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GameController {
    private static final int MAX_TIMES = 6;
    private final Game game;
    private final GameView gameView;

    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void play(InputCommand command) {
        GuessResult guessResult = game.guess(command.input());
        gameView.showMessage(guessResult);
    }
}
