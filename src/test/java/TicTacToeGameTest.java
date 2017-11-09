import game.TicTacToeGame;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jxzhong on 2017/11/8.
 */
public class TicTacToeGameTest {

    @Rule
    public ExpectedException expection = ExpectedException.none();
    private TicTacToeGame ticTacToeGame;

    @Before
    public void beforeMethod() throws Exception {
        ticTacToeGame = new TicTacToeGame();
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_input_4_on_horizontal_axis() throws Exception {

        ticTacToeGame.play(4, 2);
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_input_4_on_vertical_axis() throws Exception {
        ticTacToeGame.play(1, 4);
    }

    @Test
    public void should_throw_exception_when_input_the_duplicated_x_y() throws Exception {
        ticTacToeGame.play(1, 2);
        expection.expect(RuntimeException.class);
        ticTacToeGame.play(1, 2);
    }

    @Test
    public void should_begin_from_X_player_placeholder() throws Exception {
        assertThat(ticTacToeGame.getNextPlayer(), is('X'));
    }

    @Test
    public void should_turn_to_player_O_after_X_play_once() throws Exception {
        ticTacToeGame.play(1, 2);
        assertThat(ticTacToeGame.getNextPlayer(), is('O'));
    }

    @Test
    public void should_turn_to_player_X_after_O_play_once() throws Exception {
        ticTacToeGame.play(1, 2);
        ticTacToeGame.play(2, 2);
        assertThat(ticTacToeGame.getNextPlayer(), is('X'));
    }
}
