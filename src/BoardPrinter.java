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
    String text = "";
    for(int i=0;i<3;i++) {
      if (board[i] == "X") {
        text += "X";
      } else if (board[i] == "O") {
        text += "O";
      } else {
        text += " ";
      }
      if (i == 0 || i == 1) {
        text += "|";
      }
    }
    text += "\n-----\n";
    for(int i=3;i<6;i++) {
      if(board[i] == "X") {
        text += "X";
      } else if(board[i] == "O") {
        text += "O";
      } else {
        text += " ";
      }
      if(i == 3 || i == 4) {
        text += "|";
      }
    }
    text += "\n-----\n";
    for(int i=6;i<9;i++) {
      if(board[i] == "X") {
        text += "X";
      } else if(board[i] == "O") {
        text += "O";
      } else {
        text += " ";
      }
      if(i == 6 || i == 7) {
        text += "|";
      }
    }
    return text;
  }

  public void drawBoard(String[] board) {
    out.println(viewBoard(board));
  }

}
