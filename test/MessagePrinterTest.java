import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/18/14.
 */
public class MessagePrinterTest {

  PrintStream printStream;
  MessagePrinter messagePrinter;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    messagePrinter = new MessagePrinter(printStream);
  }

  @Test
  public void shouldPrintMessages() {
    messagePrinter.print("Player 1: enter your move.");
    verify(printStream).println("Player 1: enter your move.");
  }

}
