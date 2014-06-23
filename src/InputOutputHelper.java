import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by richiethomas on 6/22/14.
 */
public class InputOutputHelper {

    private PrintStream out;
    private BufferedReader reader;

    public InputOutputHelper(BufferedReader reader, PrintStream out) {
        this.out = out;
        this.reader = reader;
    }

    public int getValidMove(Board board) throws IOException {
        int move = Integer.parseInt(reader.readLine()) - 1;
        while(board.isPositionTaken(move)) {
            out.println("Location already taken. Please choose again.");
            move = Integer.parseInt(reader.readLine()) - 1;
        }
        return move;
    }

    public void enterPlayerInstructions(Player player) {
        out.println(String.format("Player %s: Enter a move.\n", player.getSymbol()));
    }
}
