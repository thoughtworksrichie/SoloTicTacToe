import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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
  private ArrayList<String> board;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    board = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
    boardPrinter = new BoardPrinter(printStream, board);
  }

  @Test
  public void shouldDrawEmptyBoardOnStartup() {
    boardPrinter.drawBoard(board);
    verify(printStream).println(" | | \n-----\n | | \n-----\n | | ");
  }

  @Test
  public void shouldReturnBoardWithCorrectMoves() {
    board.set(3, "X");
    boardPrinter.drawBoard(board);
    verify(printStream).println(" | | \n-----\nX| | \n-----\n | | ");
  }

  @Test
  public void shouldDrawBoardWithCorrectMovedIndicated() {
    board.set(3, "X");
    boardPrinter.drawBoard(board);
    verify(printStream).println(" | | \n-----\nX| | \n-----\n | | ");
  }

}
