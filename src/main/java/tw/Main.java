package tw;

import tw.commands.GuessInputCommand;
import tw.controllers.GameController;
import tw.exception.OutOfRangeAnswerException;
import tw.generator.AnswerGenerator;
import tw.generator.RandomIntGenerator;
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

    private static GameController createGameController() throws OutOfRangeAnswerException {
        GameView gameView = new GameView();
        Game game = new Game(new AnswerGenerator(new RandomIntGenerator()));
        return new GameController(game, gameView);
    }
}
