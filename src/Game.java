import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by richiethomas on 6/18/14.
 */
public class Game {

  private List<String> board;
  private BufferedReader inputCollector;
  private BoardPrinter boardPrinter;
  private PrintStream out;

  public Game(BufferedReader inputCollector, PrintStream out, BoardPrinter boardPrinter, List<String> board) {
    this.board = board;
    this.inputCollector = inputCollector;
    this.boardPrinter = boardPrinter;
    this.out = out;
  }

  public void go() {
    try {
      boardPrinter.drawBoard(board);
      out.print("Player 1: Enter a move.\n");
      int move = getPlayerMove();
      board.set(move-1, "X");
      boardPrinter.drawBoard(board);
      out.print("Player 2: Enter a move.\n");
//      move = getPlayerMove();
//      board[move-1] = "O";
//      boardPrinter.drawBoard(board);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public int getPlayerMove() throws IOException {
    int playerAnswer = Integer.parseInt(inputCollector.readLine());
    return playerAnswer;
  }

}
