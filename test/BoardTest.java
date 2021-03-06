import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/21/14.
 */
public class BoardTest {

    private Board board;
    private PrintStream out;
    private Player player;
    private InputOutputHelper ioHelper;
    private List<String> moves;

    @Before
    public void setUp(){
        player = mock(Player.class);
        ioHelper = mock(InputOutputHelper.class);
        out = mock(PrintStream.class);
        moves = Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        board = new Board(out, moves);
    }

    @Test
    public void shouldBeBlankOnGameStart() {
        assertThat(moves.contains("X"), is(false));
        assertThat(moves.contains("O"), is(false));
    }

    @Test
    public void shouldMarkCorrectPositionUponUserInput() throws IOException {
        when(player.getSymbol()).thenReturn("X");
        board.setMoveForPlayer(0, player);
        assertThat(moves.get(0), is(player.getSymbol()));
    }

    @Test
    public void shouldReturnTrueWhenAnyRowFilled() {
        when(player.getSymbol()).thenReturn("X");
        board.setMoveForPlayer(0, player);
        board.setMoveForPlayer(1, player);
        board.setMoveForPlayer(2, player);
        assertThat(board.anyRowFilled(player), is(true));
    }

    @Test
    public void shouldReturnTrueWhenAnyColumnFilled() {
        when(player.getSymbol()).thenReturn("X");
        board.setMoveForPlayer(0, player);
        board.setMoveForPlayer(3, player);
        board.setMoveForPlayer(6, player);
        assertThat(board.anyColumnFilled(player), is(true));
    }

    @Test
    public void shouldReturnTrueWhenAnyDiagonalFilled() {
        when(player.getSymbol()).thenReturn("X");
        board.setMoveForPlayer(0, player);
        board.setMoveForPlayer(4, player);
        board.setMoveForPlayer(8, player);
        board.draw();
        assertThat(board.anyDiagonalFilled(player), is(true));
    }


}
