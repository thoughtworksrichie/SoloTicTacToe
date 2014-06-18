import java.io.PrintStream;

/**
 * Created by richiethomas on 6/18/14.
 */
public class BoardPrinter {

  private PrintStream out;

  public BoardPrinter(PrintStream out) {
    this.out = out;
  }

  public void print() {
    out.println("_|_|_\n_|_|_\n | | \n");
  }

}
