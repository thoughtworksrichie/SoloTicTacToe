import java.io.PrintStream;
import java.util.List;

/**
 * Created by richiethomas on 6/18/14.
 */
public class BoardPrinter {

  private List<String> board;
  private PrintStream out;

  public BoardPrinter(PrintStream out, List<String> board) {
    this.board = board;
    this.out = out;
  }

  public void drawBoard(List<String> board) {
    String text = String.format(
                  "%s|%s|%s\n" +
                  "-----\n" +
                  "%s|%s|%s\n" +
                  "-----\n" +
                  "%s|%s|%s",
                  board.get(0), board.get(1), board.get(2),
                  board.get(3), board.get(4), board.get(5),
                  board.get(6), board.get(7), board.get(8));
    out.println(text);
  }


}
