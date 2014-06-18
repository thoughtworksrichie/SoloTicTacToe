import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by richiethomas on 6/18/14.
 */
public class Game {

  private String[] board;
  private BufferedReader inputCollector;
  private BoardPrinter boardPrinter;
  private MessagePrinter messagePrinter;

  public Game(BufferedReader inputCollector, MessagePrinter messagePrinter, BoardPrinter boardPrinter, String[] strings) {
    this.board = strings;
    this.inputCollector = inputCollector;
    this.boardPrinter = boardPrinter;
    this.messagePrinter = messagePrinter;
  }

  public void go() {
    try {
      boardPrinter.drawBoard(board);
      messagePrinter.print("Player 1: Enter a move.");
      int move = getPlayerMove();
      board[move-1] = "X";
      boardPrinter.drawBoard(board);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public int getPlayerMove() throws IOException, WrongInputException {
    int playerAnswer = Integer.parseInt(inputCollector.readLine());
    if(playerAnswer < 1 || playerAnswer > 9) {
      throw new WrongInputException("Please pick a number between 1 and 9 next time.");
    }
    return playerAnswer;
  }

}
