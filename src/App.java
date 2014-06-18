import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;


/**
 * Created by richiethomas on 6/18/14.
 */
public class App {
  public static void main(String[] args) {
    MessagePrinter messagePrinter = new MessagePrinter(System.out);
    BoardPrinter boardPrinter = new BoardPrinter(System.out);
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader inputCollector = new BufferedReader(isr);
    String[] board = new String[9];
    Game game = new Game(inputCollector, messagePrinter, boardPrinter, board);
    game.go();
  }
}
