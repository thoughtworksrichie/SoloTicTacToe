import java.io.PrintStream;

/**
 * Created by richiethomas on 6/18/14.
 */
public class BoardPrinter {

  private PrintStream out;

  public BoardPrinter(PrintStream out) {
    this.out = out;
  }

  public String viewBoard(String[] board) {
    String text = oneRowOfBoard(0, 3, false, board);
    text += oneRowOfBoard(3, 6, false, board);
    text += oneRowOfBoard(6, 9, true, board);
    return text;
  }

  public void drawBoard(String[] board) {
    out.println(viewBoard(board));
  }

  private String oneRowOfBoard(int min, int max, boolean isLastRow, String[] board) {
    String text = "";
    for(int i=min;i<max;i++) {
      if (board[i] == "X") {
        text += "X";
      } else if (board[i] == "O") {
        text += "O";
      } else {
        text += " ";
      }
      if (i == min || i == min+1) {
        text += "|";
      }
    }
    if(!isLastRow) {
      text += "\n-----\n";
    }
    return text;
  }

}
