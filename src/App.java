import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.InputStreamReader;


/**
 * Created by richiethomas on 6/18/14.
 */
public class App {
  public static void main(String[] args) {
    try {
        PrintStream out = System.out;
        Board board = new Board(out, Arrays.asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
        InputStreamReader isr = new InputStreamReader(System.in);
        InputOutputHelper ioHelper = new InputOutputHelper(new BufferedReader(isr), out);
        Player player1 = new Player(ioHelper, "X", board);
        Player player2 = new Player(ioHelper, "O", board);
        PlayerAlternator alternator = new PlayerAlternator(player1, player1, player2);
        Game game = new Game(board, alternator, out);
        game.go();
    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}
