import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.InputStreamReader;


/**
 * Created by richiethomas on 6/18/14.
 */
public class App {
  public static void main(String[] args) {

    List<String> board = new ArrayList<String>(
            Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));

    BoardPrinter boardPrinter = new BoardPrinter(System.out, board);
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader inputCollector = new BufferedReader(isr);
    PrintStream out = System.out;
    Game game = new Game(inputCollector, out, boardPrinter, board);
    game.go();
  }
}
