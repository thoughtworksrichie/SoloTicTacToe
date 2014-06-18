import java.io.PrintStream;

/**
 * Created by richiethomas on 6/18/14.
 */
public class MessagePrinter {

  private PrintStream out;

  public MessagePrinter(PrintStream out) {
    this.out = out;
  }

  public void print(String message) {
    out.println(message);
  }
}
