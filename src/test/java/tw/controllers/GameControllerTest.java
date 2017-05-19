package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.Answer;
import tw.Game;
import tw.commands.InputCommand;
import tw.generator.AnswerGenerator;
import tw.model.GuessResult;
import tw.views.GameView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GameControllerTest {

    @Mock
    private GameView mockGameView;
    @Mock
    private InputCommand mockCommand;
    @Mock
    private AnswerGenerator mockGenerator;
    @Mock
    private Game game;

    private Answer correctAnswer;
    private Answer errorAnswer;
    private GameController gameController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        correctAnswer = Answer.createAnswer("1 2 3 4");
        errorAnswer = Answer.createAnswer("1 2 5 6");

        when(mockGenerator.generate()).thenReturn(correctAnswer);
//        game = new Game(mockGenerator);
        gameController = new GameController(game, mockGameView);
    }

    @Test
    public void should_display_guess_result_when_call_controller_play() {
        //given
        when(mockCommand.input()).thenReturn(errorAnswer);
        when(game.checkCoutinue()).thenReturn(true);
        when(game.guess(errorAnswer)).thenReturn(new GuessResult("", errorAnswer));
        GameController gameController = new GameController(game, mockGameView);

        //when
        gameController.play(mockCommand);

        //then
        verify(mockGameView).showMessage(any());
    }

    @Test
    public void should_get_the_result_of_game_when_call_the_checkResult() {
        //given
        when(game.checkStatus()).thenReturn("any status");
        //when
        gameController.checkResult();

        //then
        verify(mockGameView).showResult(eq("any status"));
    }

    @Test
    public void should_get_history_of_guess_when_call_guessHistory() throws Exception {
        //given
        List<GuessResult> guessResults = new ArrayList<>();
        when(game.guessHistory()).thenReturn(guessResults);
        //when
        gameController.showGuessHistory();

        //then
        verify(mockGameView).showGuessHistory(eq(guessResults));

    }
}

