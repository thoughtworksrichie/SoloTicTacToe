import org.junit.Test;

import java.io.PrintStream;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/18/14.
 */
public class MessagePrinterTest {

  @Test
  public void shouldPrintPlayer1MoveMessageOnGameStart() {
    PrintStream printStream = mock(PrintStream.class);
    MessagePrinter messagePrinter = new MessagePrinter(printStream);
    messagePrinter.print("Player 1: enter your move.");
    verify(printStream).println("Player 1: enter your move.");
  }

}
