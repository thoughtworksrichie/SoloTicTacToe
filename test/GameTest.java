import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/18/14.
 */
public class GameTest {

    private Game game;
    private Board board;
    private PlayerAlternator alternator;
    private InputOutputHelper ioHelper;
    private PrintStream out;
    private Player player;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        alternator = mock(PlayerAlternator.class);
        board = mock(Board.class);
        ioHelper = mock(InputOutputHelper.class);
        player = mock(Player.class);
        when(player.getSymbol()).thenReturn("X");
        game = new Game(board, alternator, out);
    }

    @Test
    public void shouldBeADrawWhenBoardIsFull() throws Exception {
        when(board.isFull()).thenReturn(true);
        game.go();
        verify(out).println("Game is a draw.");
    }

    @Test
    public void shouldPrintBoardWhenGameStarts() throws Exception {
        when(alternator.setFirstPlayer()).thenReturn(player);
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.go();
        verify(board).draw();
    }

    @Test
    public void shouldMovePlayer() throws IOException {
        when(alternator.setFirstPlayer()).thenReturn(player);
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.go();
        verify(player).move();
    }

    @Test
    public void shouldSetFirstPlayerAssignment() throws IOException {
        when(board.isFull()).thenReturn(true);
        game.go();
        verify(alternator).setFirstPlayer();
    }

    @Test
    public void shouldAlternatePlayer() throws Exception {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(alternator.setFirstPlayer()).thenReturn(player);
        game.go();
        verify(alternator).toggleCurrentPlayer();
    }

}
