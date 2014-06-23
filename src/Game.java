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
        while(!(board.isFull() || wonBy(currentPlayer))) {
            board.draw();
            currentPlayer.move();
            if (wonBy(currentPlayer)) {
                out.printf("Player %s wins!\n", currentPlayer.getSymbol());
            }else if(board.isFull()) {
                out.println("Game is a draw.\n");
            } else {
                currentPlayer = alternator.toggleCurrentPlayer();
            }
        }
        out.println("Game over.\n");
    }

    public Boolean wonBy(Player player) {
        if (board.anyRowFilled(player) || board.anyColumnFilled(player) || board.anyDiagonalFilled(player)) {
            return true;
        }
        return false;
    }
}
