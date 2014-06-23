import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/21/14.
 */
public class MessagePrinterTest {

  private PrintStream out;
  private Player player;
  private Board board;
  private InputOutputHelper ioHelper;

  @Before
  public void setUp() {
    out = mock(PrintStream.class);
    player = mock(Player.class);
    ioHelper = mock(InputOutputHelper.class);
    board = mock(Board.class);
  }






//  @Test
//  public void shouldPrintPlayer2MoveMessageAfterPlayer1Moves() throws IOException {
//    when(inputCollector.readLine()).thenReturn("6").thenReturn("5");
//    game.go();
//    verify(out).print("Player 2: Enter a move.\n");
//  }

}
