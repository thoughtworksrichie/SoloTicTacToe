import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richiethomas on 6/18/14.
 */
public class Game {

  private List<String> board;
  private BufferedReader inputCollector;
  private BoardPrinter boardPrinter;
  private PrintStream out;
  private Player player1;
  private Player player2;

  public Game(BufferedReader inputCollector, PrintStream out, BoardPrinter boardPrinter, List<String> board) {
    this.board = board;
    this.inputCollector = inputCollector;
    this.boardPrinter = boardPrinter;
    this.out = out;
  }

  public void go() {
      player1 = new Player("1", "X");
      player2 = new Player("2", "O");
      boardPrinter.drawBoard(board);
      takeTurn(player1);
      boardPrinter.drawBoard(board);
      takeTurn(player2);
      boardPrinter.drawBoard(board);
  }

  public void takeTurn(Player player) {
    try {
      displayEnterMoveMessage(player);
      int move = getPlayerMove();
      move = isPositionTaken(move);
      setPlayerMove(player, move);
      checkIfGameOver(board);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  private int isPositionTaken(int move) throws IOException {
    while(board.get(move-1) != " ") {
      out.println("Location already taken. Please choose again.");
      move = getPlayerMove();
    }
    return move;
  }

  private void displayEnterMoveMessage(Player player) {
    out.print(String.format("Player %s: Enter a move.\n", player.number));
  }

  private void setPlayerMove(Player player, int move) {
    board.set(move-1, player.symbol);
  }

  private void checkIfGameOver(List<String> board) {
    if(!board.contains(" ")) {
      out.println("Game is a draw");
      System.exit(0);
    }
  }

  public int getPlayerMove() throws IOException {
    int playerAnswer = Integer.parseInt(inputCollector.readLine());
    return playerAnswer;
  }

}
