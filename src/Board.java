import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by richiethomas on 6/21/14.
 */
public class Board {

    private List<String> moves;
    private PrintStream out;

    public Board(PrintStream out, List<String> moves) {
        this.moves = moves;
        this.out = out;
    }

    public String getMoveAtPosition(int space) {
        return moves.get(space);
    }

    public Boolean isPositionTaken(int move) {
        return !moves.get(move).equals(" ");
    }

    public void setMoveForPlayer(int move, Player player) {
        moves.set(move, player.getSymbol());
    }

    public boolean isFull() {
        return !moves.contains(" ");
    }

    public void draw() {
        String text = String.format(
                "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s",
                getMoveAtPosition(0), getMoveAtPosition(1), getMoveAtPosition(2),
                getMoveAtPosition(3), getMoveAtPosition(4), getMoveAtPosition(5),
                getMoveAtPosition(6), getMoveAtPosition(7), getMoveAtPosition(8));
        out.println(text);
    }

}
