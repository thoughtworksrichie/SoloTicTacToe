import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/18/14.
 */
public class BoardPrinterTest {

  private PrintStream printStream;
  private BoardPrinter boardPrinter;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    boardPrinter = new BoardPrinter(printStream);
  }

  @Test
  public void shouldDrawEmptyBoardOnStartup() {
    String[] board = new String[9];
    assertThat(boardPrinter.viewBoard(board), is(" | | \n-----\n | | \n-----\n | | "));
  }

  @Test
  public void shouldReturnBoardWithCorrectMoves() {
    String[] board = new String[9];
    board[3] = "X";
    assertThat(boardPrinter.viewBoard(board), is(" | | \n-----\nX| | \n-----\n | | "));
  }

  @Test
  public void shouldDrawBoardWithCorrectMovedIndicated() {
    String[] board = new String[9];
    board[3] = "X";
    boardPrinter.drawBoard(board);
    verify(printStream).println(" | | \n-----\nX| | \n-----\n | | ");
  }

}
