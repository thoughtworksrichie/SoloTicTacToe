import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/18/14.
 */
public class GameTest {

  private Game game;
  private String[] board;
  private BufferedReader inputCollector;
  MessagePrinter messagePrinter;
  BoardPrinter boardPrinter;

  @Before
  public void setUp() {
    inputCollector = mock(BufferedReader.class);
    messagePrinter = mock(MessagePrinter.class);
    boardPrinter = mock(BoardPrinter.class);
    board = new String[9];
    game = new Game(inputCollector, messagePrinter, boardPrinter, board);
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
    assertThat(board[0], is("X"));
  }

  @Test
  public void shouldPrintPlayer2MoveMessageAfterPlayer1Moves() throws IOException {
    when(inputCollector.readLine()).thenReturn("5");
    game.go();
    verify(messagePrinter).print("Player 2: Enter a move.");
  }

  @Test
  public void shouldPrintPlayer1MoveMessageOnGameStart() throws IOException {
    when(inputCollector.readLine()).thenReturn("5");
    game.go();
    verify(messagePrinter).print("Player 1: Enter a move.");
  }
}
