import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/22/14.
 */
public class InputOutputHelperTest {

    private PrintStream out;
    private InputOutputHelper ioHelper;
    private Player player;
    private BufferedReader reader;
    private Board board;

    @Before
    public void setUp() {
        player = mock(Player.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        out = mock(PrintStream.class);
        ioHelper = new InputOutputHelper(reader, out);
        when(player.getSymbol()).thenReturn("X");
    }

    @Test
    public void shouldNotAllowMoveWhenLocationTaken() throws IOException {
        when(player.getSymbol()).thenReturn("X");
        when(reader.readLine()).thenReturn("2").thenReturn("2").thenReturn("3");
        int move = Integer.parseInt(reader.readLine())-1;
        when(board.isPositionTaken(move)).thenReturn(true);
        ioHelper.getValidMove(board);
        verify(out).println("Location already taken. Please choose again.");
    }

    @Test
    public void shouldAllowMoveWhenLocationNotTaken() throws IOException {
        when(player.getSymbol()).thenReturn("X");
        when(reader.readLine()).thenReturn("2").thenReturn("2");
        int move = Integer.parseInt(reader.readLine())-1;
        when(board.isPositionTaken(move)).thenReturn(false);
        ioHelper.getValidMove(board);
        verify(out, never()).println("Location already taken. Please choose again.");
    }

    @Test
    public void shouldPromptUserForInput() {
        ioHelper.enterPlayerInstructions(player);
        verify(out).println("Player X: Enter a move.\n");
    }

}
