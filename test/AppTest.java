import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by richiethomas on 6/18/14.
 */
public class AppTest {

  @Test
  public void shouldDrawBoard() {
    PrintStream printStream = mock(PrintStream.class);
    BoardPrinter printer = new BoardPrinter(printStream);
    printer.print();
    verify(printStream).println("_|_|_\n_|_|_\n | | \n");
  }

}
