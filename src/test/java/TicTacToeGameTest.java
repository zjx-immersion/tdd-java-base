import game.TicTacToeGame;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jxzhong on 2017/11/8.
 */
public class TicTacToeGameTest {

    @Rule
    public ExpectedException expection = ExpectedException.none();
    private TicTacToeGame ticTacToeGame;
    private String PLAYER_O_CONTINUE_RETURN_STR = "O Please Continue to play";
    private String PLAYER_X_CONTINUE_RETURN_STR = "X Please Continue to play";

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
        //given
        expection.expect(RuntimeException.class);
        //when
        ticTacToeGame.play(1, 2);
        //then
        ticTacToeGame.play(1, 2);
    }

    @Test
    public void should_begin_from_X_player_placeholder() throws Exception {
        ////when .. then
        assertThat(ticTacToeGame.getNextPlayer()).isEqualTo('X');
    }

    @Test
    public void should_turn_to_player_O_after_X_play_once() throws Exception {
        //given
        ticTacToeGame.play(1, 2);
        //when .. then
        assertThat(ticTacToeGame.getNextPlayer()).isEqualTo('O');
    }

    @Test
    public void should_turn_to_player_X_after_O_play_once() throws Exception {
        //given
        ticTacToeGame.play(2, 2);
        ticTacToeGame.play(1, 2);
        //when .. then
        assertThat(ticTacToeGame.getNextPlayer()).isEqualTo('X');
    }

    @Test
    public void should_return_continue_when_no_three_same_piece_in_a_line() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(1, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 2)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
    }

    @Test
    public void should_return_win_when_horizontal_axis_filled_3_same_piece() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(2, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 1)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 3)).isEqualTo("X Win");
    }

    @Test
    public void should_return_win_when_vertical_axis_filled_3_same_piece() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(1, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 3)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 2)).isEqualTo("O Win");
    }

    @Test
    public void should_return_win_when_positive_diagonal_line_filled_3_smae_piece() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(1, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 3)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 3)).isEqualTo("X Win");

    }

    @Test
    public void should_return_win_when_negative_diagonal_line_filled_3_smae_piece() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(1, 3)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 3)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 1)).isEqualTo("X Win");

    }


    @Test
    public void should_return_game_draw_when_negative_diagonal_line_filled_3_smae_piece() throws Exception {
        //given
        //when
        //then
        assertThat(ticTacToeGame.play(1, 3)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 1)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 1)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(2, 3)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(1, 2)).isEqualTo(PLAYER_O_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 2)).isEqualTo(PLAYER_X_CONTINUE_RETURN_STR);
        assertThat(ticTacToeGame.play(3, 3)).isEqualTo("Game Draw");

    }
}
