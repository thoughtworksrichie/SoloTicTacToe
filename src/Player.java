import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by richiethomas on 6/21/14.
 */
public class Player {

    private Board board;
    private String symbol;
    private InputOutputHelper ioHelper;

    public Player(InputOutputHelper ioHelper, String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
        this.ioHelper = ioHelper;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void move() throws IOException {
        ioHelper.enterPlayerInstructions(this);
        int move = ioHelper.getValidMove(board);
        board.setMoveForPlayer(move, this);
    }



}
