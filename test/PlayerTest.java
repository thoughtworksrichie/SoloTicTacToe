import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/21/14.
 */
public class PlayerTest {

    private InputOutputHelper ioHelper;
    private Board board;
    private Player player;

    @Before
    public void setUp() {
        PrintStream out = mock(PrintStream.class);
        board = new Board(out, Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        ioHelper = mock(InputOutputHelper.class);
        player = new Player(ioHelper, "X", board);
    }

    @Test
    public void shouldGetMoveWhenTurnTaken() throws IOException {
        player.move();
        verify(ioHelper).getValidMove(board);
    }

}
