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
  private String[] strings;
  private BufferedReader inputCollector;

  @Before
  public void setUp() {
    inputCollector = mock(BufferedReader.class);
    MessagePrinter messagePrinter = mock(MessagePrinter.class);
    BoardPrinter boardPrinter = mock(BoardPrinter.class);
    strings = new String[9];
    game = new Game(inputCollector, messagePrinter, boardPrinter, strings);
  }

  @Test
  public void shouldBeBlankOnGameStart() {
    // verify that the game's board is initially blank
    assertThat(Arrays.asList(strings).contains("X"), is(false));
    assertThat(Arrays.asList(strings).contains("O"), is(false));
  }

  @Test
  public void shouldMarkCorrectPositionUponUserInput() throws IOException {
    // verify that the correct array position is marked upon user input
    when(inputCollector.readLine()).thenReturn("1");
    game.go();
    assertThat(strings[0], is("X"));
  }

  public void shouldThrowErrorIfWrongInputFormat() throws WrongInputException, IOException {
    when(inputCollector.readLine()).thenReturn("1");
    game.go();
    assertThat(strings[0], is("X"));
  }
}
