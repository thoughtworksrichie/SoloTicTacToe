import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/18/14.
 */
public class GameTest {

  private Game game;
  private List<String> board;
  private BufferedReader inputCollector;
  PrintStream out;
  BoardPrinter boardPrinter;

  @Before
  public void setUp() {
    inputCollector = mock(BufferedReader.class);
    out = mock(PrintStream.class);
    boardPrinter = mock(BoardPrinter.class);
    board = new ArrayList<String>(Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
    game = new Game(inputCollector, out, boardPrinter, board);
  }

  @Test
  public void shouldBeBlankOnGameStart() {
    // verify that the game's board is initially blank
    assertThat(Arrays.asList(board).contains("X"), is(false));
    assertThat(Arrays.asList(board).contains("O"), is(false));
  }

  @Test
  public void shouldMarkCorrectPositionUponUserInput() throws IOException {
    // verify that the correct array position is marked upon user input
    when(inputCollector.readLine()).thenReturn("1");
    game.go();
    assertThat(board.get(0), is("X"));
  }

  @Test
  public void shouldPrintPlayer1MoveMessageOnGameStart() throws IOException {
    when(inputCollector.readLine()).thenReturn("5");
    game.go();
    verify(out).print("Player 1: Enter a move.\n");
  }

  @Test
  public void shouldPrintPlayer2MoveMessageAfterPlayer1Moves() throws IOException {
    when(inputCollector.readLine()).thenReturn("5");
    game.go();
    verify(out).print("Player 2: Enter a move.\n");
  }

  @Test
  public void shouldPrintLocationTakenWhenLocationTaken() throws IOException {
    when(inputCollector.readLine()).thenReturn("5").thenReturn("5").thenReturn("6");
    game.go();
    verify(out).println("Location already taken. Please choose again.");
  }
}
