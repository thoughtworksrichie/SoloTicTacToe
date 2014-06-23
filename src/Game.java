import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by richiethomas on 6/18/14.
 */
public class Game {

    private Board board;
    private PlayerAlternator alternator;
    private PrintStream out;

    public Game(Board board, PlayerAlternator alternator, PrintStream out) {
        this.board = board;
        this.alternator = alternator;
        this.out = out;
    }

    public void go() throws IOException {
        Player currentPlayer = alternator.setFirstPlayer();
        while(!board.isFull()) {
            board.draw();
            currentPlayer.move();
            currentPlayer = alternator.toggleCurrentPlayer();
        }
        out.println("Game is a draw.");
    }
}
