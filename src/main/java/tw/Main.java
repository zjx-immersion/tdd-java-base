package tw;

import tw.commands.GuessInputCommand;
import tw.controllers.GameController;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        GameController gameController = createGameController();
        gameController.beginGame();
        gameController.play(new GuessInputCommand());

    }

    //todo create a factory to create the controller
    private static GameController createGameController() throws OutOfRangeAnswerException {
        GameView gameView = new GameView();
        Game game = new Game(new AnswerGenerator(new RandomIntGenerator()));
        return new GameController(game, gameView);
    }
}
